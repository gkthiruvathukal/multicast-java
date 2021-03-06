package com.thiruvathukal.ds.multicast;

import com.thiruvathukal.ds.common.*;

import java.io.*;
import java.net.*;
import java.util.*;

/* Adapted from Quote Client/Server examples in Java documentations. */

public class MulticastClient {

    public static void main(String[] args) throws IOException {
        ExampleProperties properties = ExampleProperties.getExampleProperties();
        MulticastSocket socket = new MulticastSocket(properties.getPort());
        String multicastAddress = properties.getMulticastAddress();
        InetAddress address = InetAddress.getByName(multicastAddress);
        socket.joinGroup(address);

        DatagramPacket packet;

        // get a few quotes
        for (int i = 0; i < 5; i++) {

            byte[] buf = new byte[256];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Quote of the Moment: " + received);
        }

        socket.leaveGroup(address);
        socket.close();
    }

}

