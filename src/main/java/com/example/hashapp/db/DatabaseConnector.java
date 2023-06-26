package com.example.hashapp.db;

import com.example.hashapp.model.Hash;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateful
public class DatabaseConnector {

    @PersistenceContext
    private EntityManager manager;

    public void save(String hashValue) {
        Hash hash = new Hash();
        hash.setHashValue(hashValue);
        manager.persist(hash);
    }

    public void delete(Long id) {
        Query query = manager.createQuery("delete from Hash h where h.id = :id");
        query.setParameter("id", id).executeUpdate();
    }

    public Hash getById(Long id) {
        Query query = manager.createQuery("select h from Hash h where h.id = :id");
        query.setParameter("id", id);
        return (Hash) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Hash> getAll() {
        return (List<Hash>) manager.createQuery("select h from Hash h").getResultList();
    }
}
