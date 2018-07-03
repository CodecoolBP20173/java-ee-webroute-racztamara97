package com.code.cool.racztami;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.createContext("/index", new RequestHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }



}
