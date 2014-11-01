Raw TCP Proxy
=====

> This is a protocol independent TCP proxy. It is compatible with **any** TCP software; such as web servers, Minecraft servers, secure shell, and much much more. It was developed to have no limitations - literally.

[![Build Status](https://travis-ci.org/brendanashworth/Raw-TCP-Proxy.png?branch=master)](https://travis-ci.org/brendanashworth/Raw-TCP-Proxy)

### Usage
Usage is very simple, as a Perl wrapper is provided.
```bash
$ git clone https://github.com/boboman13/Raw-TCP-Proxy.git && cd Raw-TCP-Proxy
$ ./bin/proxy.pl
```

This provides a help screen. The usage is as follows:
```bash
$ ./bin/proxy.pl 0.0.0.0:1357 127.0.0.1:1358
```
The first argument is the listening IP / port, and the second argument is the output IP / port.

If you want to access the Java .jar directly, you can access the flags at [the Main file](./src/main/java/net/boboman13/raw_tcp_proxy/main/Main.java).

### Compilation
This is without the Perl wrapper.
```bash
$ git clone https://github.com/boboman13/Raw-TCP-Proxy.git
$ mvn clean package
```

### Contributing
#### Pulling up a Vagrant VM
We use Vagrant to have a standard that we can abide by.
```bash
$ vagrant up
$ vagrant ssh
```

Simply fork the repository, change the local repository, then send a pull request in with the changes. The pull request will then be reviewed by the project manager/s and may or may not be accepted.

The program changes must reflect the following project goals:
* Speed: The proxy needs to be very fast. Any pull requests that make the program slower that are not balanced out by a necessary feature will not be accepted.
* Independence: The proxy must be protocol independent. If a change is made for a specific protocol (HTTP for example) it will NOT be accepted. However, go ahead and keep the changes on your local repository.
