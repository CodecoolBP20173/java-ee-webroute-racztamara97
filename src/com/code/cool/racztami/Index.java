package com.code.cool.racztami;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Index {
    public static void responseForIndex(HttpExchange request) throws IOException {
        String response = "This is the response of the index page.";
        request.sendResponseHeaders(200, response.getBytes().length);
        OutputStream outputStream = request.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}