package com.example.hashapp.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Hash")
@XmlRootElement
public class Hash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hashValue;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }
}
