package com.example.travelezweb.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description",length = 3000)
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "quality")
    private double quality;
    @Column(name="image",length = 65535,columnDefinition="Text")
    private String image;
    public Review(){

    }

    public Review(String name, String description, double price, double quality, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
