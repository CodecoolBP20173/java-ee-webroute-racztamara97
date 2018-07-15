package com.code.cool.racztami;

import java.io.IOException;
import java.io.OutputStream;
import com.code.cool.racztami.WebRoute;
import com.sun.net.httpserver.HttpExchange;

public class MyRoutes{

    private void responseWriter(HttpExchange t, String response) throws IOException {
        t.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @WebRoute(path = "/")
    void index(HttpExchange t) throws IOException {
        String response = "Index page";
        responseWriter(t, response);
    }

    @WebRoute(path = "/test1")
    void test1(HttpExchange t) throws IOException {
        String response = "This is my first test";
        responseWriter(t, response);
    }

    @WebRoute(path = "/test2")
    void test2(HttpExchange t) throws IOException {
        String response = "This is my second test";
        responseWriter(t, response);
    }
}