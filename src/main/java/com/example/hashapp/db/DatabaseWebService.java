package com.example.hashapp.db;

import com.example.hashapp.model.Hash;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class DatabaseWebService {

    @EJB
    private DatabaseConnector connector;

    @WebMethod
    public List<Hash> getAll() {
        return connector.getAll();
    }

    @WebMethod
    public Hash get(@WebParam(name = "id") Long id) {
        return connector.getById(id);
    }

    @WebMethod
    public void save(@WebParam(name = "hash") String hash) {
        connector.save(hash);
    }

    @WebMethod
    public void delete(@WebParam(name = "id") Long id) {
        connector.delete(id);
    }

}
