package com.thiruvathukal.ds.multicast;

import com.thiruvathukal.ds.common.*;

import java.io.*;
import java.net.*;
import java.util.*;

/* Adapted from Quote Client/Server examples in Java documentations. */

public class QuoteClient {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Usage: java QuoteClient <hostname>");
            return;
        }

        ExampleProperties properties = ExampleProperties.getExampleProperties();
        int port = properties.getPort();

        // get a datagram socket
        DatagramSocket socket = new DatagramSocket();

        // send request
        byte[] buf = new byte[256];
        InetAddress address = InetAddress.getByName(args[0]);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);

        // get response
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        // display response
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Quote of the Moment: " + received);

        socket.close();
    }
}

