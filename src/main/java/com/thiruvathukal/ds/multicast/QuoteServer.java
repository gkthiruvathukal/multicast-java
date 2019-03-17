package com.thiruvathukal.ds.multicast;

import java.io.*;

/* Adapted from Quote Client/Server examples in Java documentations. */

public class QuoteServer {
    public static void main(String[] args) throws IOException {
        new QuoteServerThread().start();
    }
}
