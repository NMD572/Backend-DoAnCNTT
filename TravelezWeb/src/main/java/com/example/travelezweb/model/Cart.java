package com.example.travelezweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="status")
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourid")
    @JsonIgnore
    private Tour tour;
    public Cart(){

    }

    public Cart(User user, Tour tour, String status) {
        this.user = user;
        this.tour = tour;
        this.status = status;
    }

    public Cart(int id, User user, Tour tour, String status) {
        this.id = id;
        this.user = user;
        this.tour = tour;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
