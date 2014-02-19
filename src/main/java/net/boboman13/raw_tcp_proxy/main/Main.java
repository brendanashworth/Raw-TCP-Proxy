package net.boboman13.raw_tcp_proxy.main;

import net.boboman13.raw_tcp_proxy.Proxy;

/**
 * @author boboman13
 */
public class Main {

    public static void main(String[] args) {
        String out = "127.0.0.1";
        String listenIP = "0.0.0.0";
        int port = 1358;
        int listenPort = 1357;
        boolean debug = false;

        // Parse through arguments.
        for(int i = 0; i < args.length; i++) {
            // Look for out (-o, --out)
            if(args[i].equalsIgnoreCase("-o") || args[i].equalsIgnoreCase("--out")) {
                out = args[i + 1];
            }
            // Look for port (-p, --port)
            if(args[i].equalsIgnoreCase("-p") || args[i].equalsIgnoreCase("--port")) {
                port = Integer.parseInt(args[i + 1]);
            }
            // Look for listening port (-l, --listen)
            if(args[i].equalsIgnoreCase("-l") || args[i].equalsIgnoreCase("--listen")) {
                listenPort = Integer.parseInt(args[i + 1]);
            }
            // look for host IP (-h, --host)
            if(args[i].equalsIgnoreCase("-h") || args[i].equalsIgnoreCase("--host")) {
                listenIP = args[i + 1];
            }
            // Look for debug (-d, --debug)
            if(args[i].equalsIgnoreCase("-d") || args[i].equalsIgnoreCase("--debug")) {
                debug = true;
                System.out.println("Debug mode activated.");
            }
        }

        // Initiate the Proxy
        Proxy proxy = new Proxy();
        proxy.setHost(out);
        proxy.setPort(port);
        proxy.setListeningIP(listenIP);
        proxy.setListeningPort(listenPort);
        proxy.setDebug(debug);

        // Start the proxy.
        proxy.start();
    }

}
