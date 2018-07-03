package com.code.cool.racztami;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RequestHandler implements HttpHandler {
    @Override
    @WebRoute(path = "/index")
    public void handle(HttpExchange request) {

        try {
            Method method = Class.forName("com.code.cool.racztami.Index").
                    getMethod("responseForIndex", HttpExchange.class);
            try {
                method.invoke(method, request);
                System.out.println("It's working.");
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}