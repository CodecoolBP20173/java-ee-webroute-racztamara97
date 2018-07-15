package com.code.cool.racztami;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.net.InetSocketAddress;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) {

            String requestedPath = t.getRequestURI().getPath();
            Class MyClass = MyRoutes.class;
            Method[] methods = MyClass.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getAnnotation(WebRoute.class) != null) {
                    WebRoute annotation = method.getAnnotation(WebRoute.class);
                    if (annotation.path().equals(requestedPath)) {
                        try {
                            method.invoke(new MyRoutes(), t);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

