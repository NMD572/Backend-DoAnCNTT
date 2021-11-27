package com.example.travelezweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "description",length = 1000)
    private String description;
    @Column(name = "quality")
    private double quality;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourid")
    @JsonBackReference
    private Tour tour;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JsonBackReference
    private User user;

    public Review(){

    }

    public Review(Tour tour, User user, String description, double quality) {
        this.tour = tour;
        this.user = user;
        this.description = description;
        this.quality = quality;
    }

    public Review(int id, Tour tour, User user, String description, double quality) {
        this.id = id;
        this.tour = tour;
        this.user = user;
        this.description = description;
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }
}
