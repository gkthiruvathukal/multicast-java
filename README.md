# multicast-java

Multicast Java example based on Java docs

# Build Status

[![Build Status](https://travis-ci.org/gkthiruvathukal/multicast-java.svg?branch=master)](https://travis-ci.org/gkthiruvathukal/multicast-java)


# About

This code is derived from the Java documentation at https://docs.oracle.com/javase/tutorial/networking/datagrams/index.html.

The CodeJava people have also been so kind as to recover the actual files from the docs and put it all together at https://www.codejava.net/java-se/networking/java-udp-client-server-program-example.

I've also made a number of improvements so others can run this code and learn from it:

- Added Gradle build file
- Added command-line arguments to avoid hard-coding host and port.
- Timeouts when waiting for UDP response.
- Customizable interval for generating quotes.

Details about how to run will follow. 


# Running

```
$ gradle tasks
```


