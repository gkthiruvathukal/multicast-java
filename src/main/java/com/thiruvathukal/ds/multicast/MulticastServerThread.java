package com.thiruvathukal.ds.multicast;


import com.thiruvathukal.ds.common.*;

import java.io.*;
import java.net.*;
import java.util.*;

/* Adapted from Quote Client/Server examples in Java documentations. */


public class MulticastServerThread extends QuoteServerThread {

    private long FIVE_SECONDS = 5000;

    public MulticastServerThread() throws IOException {
        super("MulticastServerThread");
    }

    public void run() {
        String multicastAddress;
        int port;
        try {
           ExampleProperties properties = ExampleProperties.getExampleProperties();
           multicastAddress = properties.getMulticastAddress();
           port = properties.getPort();
        } catch (IOException e) {
           System.err.println("Could not load properties.");
           return;
        }
        while (moreQuotes) {
            try {
                byte[] buf = new byte[256];

                // construct quote
                String dString = null;
                if (in == null)
                    dString = new Date().toString();
                else
                    dString = getNextQuote();
                buf = dString.getBytes();

                // send it
                InetAddress group = InetAddress.getByName(multicastAddress);
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, port);
                socket.send(packet);

                // sleep for a while
                try {
                    sleep((long)(Math.random() * FIVE_SECONDS));
                } catch (InterruptedException e) { }
            } catch (IOException e) {
                e.printStackTrace();
                moreQuotes = false;
            }
        }
        socket.close();
    }
}
