package com.example.travelezweb.model;

import javax.persistence.*;
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "userid")
    private int userId;
    @Column(name = "tourid")
    private int tourId;
    @Column(name="status")
    private String status;
    public Cart(){

    }

    public Cart(int userId, int tourId, String status) {
        this.userId = userId;
        this.tourId = tourId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
