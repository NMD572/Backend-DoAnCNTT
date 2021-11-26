package com.example.travelezweb.model;

import javax.persistence.*;
@Entity
@Table(name = "tourguide")
public class TourGuide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "quality")
    private double quality;
    @Column(name="image",length = 65535,columnDefinition="Text")
    private String image;
    public TourGuide(){

    }

    public TourGuide(String name, double quality, String image) {
        this.name = name;
        this.quality = quality;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
