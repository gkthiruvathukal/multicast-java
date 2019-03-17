package com.thiruvathukal.ds.datagram;

import com.thiruvathukal.ds.common.*;

import java.io.*;
import java.net.*;

/* Adapted from Quote Client/Server examples in Java documentations. */

public class QuoteClient {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Syntax: QuoteClient <hostname> <port> <milliseconds> <timeout>");
            System.out.println("  where <milliseconds> is the time to sleep between quotes");
            System.out.println("  ctrl-c to exit");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        int delay = Integer.parseInt(args[2]);
        int timeout = Integer.parseInt(args[3]);

        try {
            InetAddress address = InetAddress.getByName(hostname);
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(timeout);

            while (true) {

                DatagramPacket request = new DatagramPacket(new byte[1], 1, address, port);
                socket.send(request);

                byte[] buffer = new byte[512];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                try {
                    socket.receive(response);
                } catch (SocketTimeoutException ste) {
                    System.out.println("Timeout awaiting response...");
                }

                String quote = new String(buffer, 0, response.getLength());

                System.out.println(quote);
                System.out.println();

                Thread.sleep(delay);
            }

        } catch (SocketTimeoutException ex) {
            System.out.println("Timeout error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
