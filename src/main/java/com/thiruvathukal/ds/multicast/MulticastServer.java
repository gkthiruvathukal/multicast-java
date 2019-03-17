package com.thiruvathukal.ds.multicast;

/* Adapted from Quote Client/Server examples in Java documentations. */

public class MulticastServer {
    public static void main(String[] args) throws java.io.IOException {
        new MulticastServerThread().start();
    }
}
