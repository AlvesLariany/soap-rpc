package org.example.rpc;

import org.example.rpc.services.HelloWorldImpl;

import javax.xml.ws.Endpoint;

public class Publisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/rpc/helloworld?wsdl", new HelloWorldImpl());
        System.out.println("Ativo em http://localhost:8080/rpc/helloworld?wsdl");
    }
}
