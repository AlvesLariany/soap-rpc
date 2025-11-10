package org.example.rpc.services;
import  org.example.rpc.services.HelloWorld;
import javax.jws.WebService;


@WebService(endpointInterface = "org.example.rpc.services.HelloWorld")
public class HelloWorldImpl implements  HelloWorld{

    @Override
    public String sayHelloWorld(String name){
        return "Olá "+name;
    }
}
