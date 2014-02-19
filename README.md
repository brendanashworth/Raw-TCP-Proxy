Raw TCP Proxy
=====

> This is a protocol independent TCP proxy. It is compatible with **any** TCP software; such as web servers, Minecraft servers, secure shell, and much much more. It was developed to have no limitations - literally.

[![Build Status](https://travis-ci.org/boboman13/Raw-TCP-Proxy.png?branch=master)](https://travis-ci.org/boboman13/Raw-TCP-Proxy)

### Compilation
```bash
$ git clone https://github.com/boboman13/Raw-TCP-Proxy.git
$ mvn package
```

This will create the .jar file for running the proxy. Lets assume its named proxy.jar. For our purposes, we will be configuring a web server proxy, pushing all connections to `0.0.0.0:80` to `198.51.100.2:80`.

```bash
$ java -jar proxy.jar -h 127.0.0.1 -o 198.51.100.2 -p 80 -l 80
```

Lets take a look at this for a second.

`-o` or `--out` sets the output IP. All packets received (0.0.0.0 is default) will be sent to this IP. All packets from this IP will be sent to their respective connections to the proxy. Defaults to 127.0.0.1.

`-p` or `--port` sets the output port. All packets sent to the output IP will be sent along this port. Defaults to 1358.

`-l` or `--listen` sets the listening port. All packets sent to 0.0.0.0:{port} will be recognized by the proxy. Defaults to 1357.

`-d` or `--debug` sets the proxy to run under debug mode. All packets and registered connections will be printed to the console if this is true. Defaults to false.

`-h` or `--host` sets the listening IP. When this is set, only packets received to this IP (can also be a hostname) will be registered into the proxy. This defaults to 0.0.0.0, or all available IPs.

### Contributing
Simply fork the repository, change the local repository, then send a pull request in with the changes. The pull request will then be reviewed by the project manager/s and may or may not be accepted.

The program changes must reflect the following project goals:
* Speed: The proxy needs to be very fast. Any pull requests that make the program slower that are not balanced out by a necessary feature will not be accepted.
* Independence: The proxy must be protocol independent. If a change is made for a specific protocol (HTTP for example) it will NOT be accepted. However, go ahead and keep the changes on your local repository.