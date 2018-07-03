package com.code.cool.racztami;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange requestData) throws IOException {
        String response = "This is the response of the test page.";
        requestData.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = requestData.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
