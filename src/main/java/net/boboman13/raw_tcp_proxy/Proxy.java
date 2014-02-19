package net.boboman13.raw_tcp_proxy;

/**
 * @author boboman13
 */
public class Proxy {

    private RegistryManager registryManager;
    private ProxyServer proxyServer;

    private String host;
    private String out;
    private int port;
    private int listenPort;

    private boolean debug;

    /**
     * Creates a Proxy instance.
     */
    public Proxy() {

    }

    public void start() {
        System.out.println("Starting Raw TCP Proxy on "+host+":"+listenPort+". Will forward to "+out+":"+port+".");

        this.registryManager = new RegistryManager(this);
        this.proxyServer = new ProxyServer(this);
    }

    /**
     * Sets the host for the Proxy to send data to.
     *
     * @param host
     */
    public void setHost(String host) {
        this.out = host;
    }

    /**
     * Gets the host that the proxy is sending data to.
     *
     * @return host
     */
    public String getHost() {
        return this.out;
    }

    /**
     * Sets the port for the Proxy to send data to.
     *
     * @param port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Returns the port that the proxy is sending data to.
     *
     * @return port
     */
    public int getPort() {
        return this.port;
    }

    /**
     * Set the listening IP for the proxy.
     *
     * @param listeningIP
     */
    public void setListeningIP(String listeningIP) {
        this.host = listeningIP;
    }

    /**
     * Get the listening IP of the proxy.
     *
     * @return
     */
    public String getListeningIP() {
        return this.host;
    }

    /**
     * Set the listening port for the proxy.
     *
     * @param listenPort
     */
    public void setListeningPort(int listenPort) {
        this.listenPort = listenPort;
    }

    /**
     * Gets the listening port for the proxy.
     *
     * @return listenPort
     */
    public int getListeningPort() {
        return this.listenPort;
    }

    /**
     * Sets whether or not the Proxy should be debugging.
     *
     * @param debug
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     * Gets the state of debugging; on or off.
     *
     * @return boolean
     */
    public boolean getDebug() {
        return this.debug;
    }

    /**
     * Prints a debugging message in the terminal. This only shows if debugging mode is on.
     *
     * @param msg The message to display in the terminal.
     */
    public void debug(String msg) {
        if(this.getDebug()) {
            System.out.println("[DEBUG] "+msg);
        }
    }

    /**
     * Gets the RegistryManager of the Proxy.
     *
     * @return The RegistryManager instance.
     */
    public RegistryManager getRegistryManager() {
        return this.registryManager;
    }

}
