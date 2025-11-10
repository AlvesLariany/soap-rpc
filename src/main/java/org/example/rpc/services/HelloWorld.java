package org.example.rpc.services;

import  javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorld {

    @WebMethod
    String sayHelloWorld(String name);
}
