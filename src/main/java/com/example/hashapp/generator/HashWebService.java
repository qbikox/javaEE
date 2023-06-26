package com.example.hashapp.generator;

import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class HashWebService{

    @EJB
    private HashGenerator generator;

    @WebMethod
    public String generateHash(@WebParam(name = "bytes") byte[] bytes, @WebParam(name = "length") int length) {
        return generator.generateHash(bytes, length);
    }

}
