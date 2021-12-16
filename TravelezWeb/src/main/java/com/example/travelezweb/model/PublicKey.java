package com.example.travelezweb.model;

import javax.persistence.*;

@Entity
@Table(name = "publickey")
public class PublicKey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "e")
    private String e;
    @Column(name="n")
    private String n;
public PublicKey(){

}

    public PublicKey(String e, String n) {
        this.e = e;
        this.n = n;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }
}
