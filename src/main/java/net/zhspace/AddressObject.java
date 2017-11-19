package net.zhspace;

import java.net.InetAddress;

/**
 * Author: Zino Holwerda
 * Date: 11/18/2017.
 */
public class AddressObject {

    private InetAddress address;
    private int port;

    public AddressObject(InetAddress address, int port) {
        this.address = address;
        this.port = port;
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
