package com.example.travelezweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="status")
    private String status;          //trong gio hang(cart) --> chua check(thanh toan roi- wait) --> da check(da duyet boi admin-)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"listCartInUser", "handler", "hibernateLazyInitializer"}, allowSetters = true)
    @JoinColumn(name = "userid")
    private User userincart;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"listcartintour", "handler", "hibernateLazyInitializer"}, allowSetters = true)
    @JoinColumn(name = "tourid")
    private Tour tourincart;
    public Cart(){

    }

    public Cart(String status) {
        this.status = status;
    }

    public Cart(String status, User userincart, Tour tourincart) {
        this.status = status;
        this.userincart = userincart;
        this.tourincart = tourincart;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserincart() {
        return userincart;
    }

    public void setUserincart(User userincart) {
        this.userincart = userincart;
    }

    public Tour getTourincart() {
        return tourincart;
    }

    public void setTourincart(Tour tourincart) {
        this.tourincart = tourincart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
