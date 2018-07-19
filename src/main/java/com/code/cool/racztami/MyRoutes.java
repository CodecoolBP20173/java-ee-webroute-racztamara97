package com.code.cool.racztami;

import com.sun.net.httpserver.HttpExchange;

public class MyRoutes{

    @WebRoute(path = "/")
    String index(HttpExchange t) {
        return "Index page";
    }

    @WebRoute(path = "/test1")
    String test1(HttpExchange t) {
        return "This is my first test";
    }

    @WebRoute(path = "/test2")
    String test2(HttpExchange t) {
        return "This is my second test";
    }
}