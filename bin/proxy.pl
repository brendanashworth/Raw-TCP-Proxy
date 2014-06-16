#!/usr/bin/perl
#  The usage of this script is as follows:
#  ./bin/proxy.pl 0.0.0.0:1357 127.0.0.1:1358
#   The first argument is the location to this script. You can either use the `perl` interpreter or execute it directly.
#   The second argument is the listen IP/port.
#   The third argument is the output IP/port.
use strict;
use warnings;

# Colors
my $primary = "\e[36m";
my $secondary = "\e[33m";
my $fail = "\e[31m";
my $reset = "\e[0m";

# Before we do anything, check if they provided all the arguments.
unless (defined $ARGV[1]) {
	print($primary); # color
	print("This is the Raw TCP Proxy wrapper.\n");
	print("Example usage: \n");
	print($secondary . "  ./bin/proxy.pl 0.0.0.0:1357 127.0.0.1:1358\n");
	print($primary   . "  First argument is the listening IP / port\n");
	print(             "  Second argument is the output IP / port.\n");
	print("Use " . $secondary . "./bin/proxy.pl" . $primary . " again to access this help." . $reset . "\n");
	exit;
}

print($primary . "Compiling proxy... \n" . $reset);

`mvn package`;
# Did it compile fine?
if ( $? == -1 ) {
	print($fail . "Compiling failed. \n" . $reset);
	exit;
} else {
	print($secondary . "Compiled. " . $reset);
}

# Get the host, listening ports, output host etc.
my @listening = split(':', $ARGV[0]);
my @output = split(':', $ARGV[1]);

my $listenhost = $listening[0];
my $listenport = $listening[1];

my $outputhost = $output[0];
my $outputport = $output[1];

# Boot.
print($primary . "Booting... \n" . $reset);

my @args = ('java', '-jar', 'target/Raw-TCP-Proxy-1.0-SNAPSHOT.jar', '-h', $listenhost, '-l', $listenport, '-o', $outputhost, '-p', $outputport);

system(join(' ', @args));