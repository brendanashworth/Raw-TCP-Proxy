#!/usr/bin/perl
#  The usage of this script is as follows:
#  ./bin/proxy.pl 0.0.0.0:1357 127.0.0.1:1358
#   The first argument is the location to this script. You can either use the `perl` interpreter or execute it directly.
#   The second argument is the listen IP/port.
#   The third argument is the output IP/port.
use strict;
use warnings;

print("Compiling proxy... \n");

`mvn package`;
#system('mvn', 'package', '1>/dev/null');
# Did it compile fine?
if ( $? == -1 ) {
	print("Compiling failed. \n");
	exit;
} else {
	print("Compiled. ");
}

# Get the host, listening ports, output host etc.
my @listening = split(':', $ARGV[0]);
my @output = split(':', $ARGV[1]);

my $listenhost = $listening[0];
my $listenport = $listening[1];

my $outputhost = $output[0];
my $outputport = $output[1];

# Boot.
print("Booting... \n");

my @args = ('java', '-jar', 'target/Raw-TCP-Proxy-1.0-SNAPSHOT.jar', '-h', $listenhost, '-l', $listenport, '-o', $outputhost, '-p', $outputport);

print(join(" ", @args) . "\n");
system(join(' ', @args));