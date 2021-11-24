
package com.example.travelezweb.model;

import com.sun.istack.NotNull;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "brief",length = 1000)
    private String brief;
    @Column(name = "description",length = 3000)
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "quality")
    private double quality;
    @Column(name = "tourguideid")
    private int tourguideid;
    @Column(name = "maxmember")
    private int maxmember;
    @Column(name = "country")
    private String country;
    @Column(name = "time")
    private int time;                       //Hours
    @Column(name="image",length = 65535,columnDefinition="Text")
    private String image;

    public Tour() {
    }

    public Tour(String name, String brief, String description, double price, double quality, int tourguideid, int maxmember, String country, int time, String image) {
        this.name = name;
        this.brief = brief;
        this.description = description;
        this.price = price;
        this.quality = quality;
        this.tourguideid = tourguideid;
        this.maxmember = maxmember;
        this.country = country;
        this.time = time;
        this.image = image;
    }

    public Tour(int id, String name, String brief, String description, double price, double quality, int tourguideid, int maxmember, String country, int time, String image) {
        this.id = id;
        this.name = name;
        this.brief = brief;
        this.description = description;
        this.price = price;
        this.quality = quality;
        this.tourguideid = tourguideid;
        this.maxmember = maxmember;
        this.country = country;
        this.time = time;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
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

    public int getTourguideid() {
        return tourguideid;
    }

    public void setTourguideid(int tourguideid) {
        this.tourguideid = tourguideid;
    }

    public int getMaxmember() {
        return maxmember;
    }

    public void setMaxmember(int maxmember) {
        this.maxmember = maxmember;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", quality=" + quality +
                ", idtourguy=" + tourguideid +
                ", maxmember=" + maxmember +
                ", country='" + country + '\'' +
                ", time=" + time +
                '}';
    }



}
