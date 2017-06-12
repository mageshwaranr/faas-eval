package com.maddylabs.faas;

import org.apache.camel.Header;

public class Main {

    public Object main(String body, @Header("name") String name) {
        return "Hello " + name + ". I got payload `" + body + "` and I am on host: " + System.getenv("HOSTNAME");
    }

}