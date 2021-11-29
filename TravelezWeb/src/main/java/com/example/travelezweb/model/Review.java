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
    private Tour tourinreview;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User userinreview;

    public Review(){

    }

    public Review(String description, double quality, Tour tourinreview, User userinreview) {
        this.description = description;
        this.quality = quality;
        this.tourinreview = tourinreview;
        this.userinreview = userinreview;
    }

    public Review(int id, String description, double quality, Tour tourinreview, User userinreview) {
        this.id = id;
        this.description = description;
        this.quality = quality;
        this.tourinreview = tourinreview;
        this.userinreview = userinreview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tour getTourinreview() {
        return tourinreview;
    }

    public void setTourinreview(Tour tourinreview) {
        this.tourinreview = tourinreview;
    }

    public User getUserinreview() {
        return userinreview;
    }

    public void setUserinreview(User userinreview) {
        this.userinreview = userinreview;
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
