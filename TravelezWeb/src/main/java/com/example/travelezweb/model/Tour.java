
package com.example.travelezweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "maxmember")
    private int maxmember;
    @Column(name = "country")
    private String country;
    @Column(name = "time")
    private int time;                       //Days
    @Column(name="action")
    private String action;
    @Column(name="image",length = 65535,columnDefinition="Text")
    private String image;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourguideid")
    @JsonBackReference
    private TourGuide tourguide;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tour")
    @JsonIgnore
    private List<Review> listreview = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tour")
    @JsonIgnore
    private List<Cart> listcart = new ArrayList<>();
    public Tour() {
    }

    public Tour(String name, String brief, String description, double price, double quality, TourGuide tourguide, int maxmember, String country, int time, String action, String image) {
        this.name = name;
        this.brief = brief;
        this.description = description;
        this.price = price;
        this.quality = quality;
        this.tourguide = tourguide;
        this.maxmember = maxmember;
        this.country = country;
        this.time = time;
        this.action = action;
        this.image = image;
    }

    public Tour(String name, String brief, String description, double price, double quality, TourGuide tourguide, int maxmember, String country, int time, String action, String image, List<Review> listReview, List<Cart> listCart) {
        this.name = name;
        this.brief = brief;
        this.description = description;
        this.price = price;
        this.quality = quality;
        this.tourguide = tourguide;
        this.maxmember = maxmember;
        this.country = country;
        this.time = time;
        this.action = action;
        this.image = image;
    }

    public Tour(int id, String name, String brief, String description, double price, double quality, TourGuide tourguide, int maxmember, String country, int time, String action, String image, List<Review> listReview, List<Cart> listCart) {
        this.id = id;
        this.name = name;
        this.brief = brief;
        this.description = description;
        this.price = price;
        this.quality = quality;
        this.tourguide = tourguide;
        this.maxmember = maxmember;
        this.country = country;
        this.time = time;
        this.action = action;
        this.image = image;
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

    public TourGuide getTourguide() {
        return tourguide;
    }

    public void setTourguide(TourGuide tourguide) {
        this.tourguide = tourguide;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Review> getListreview() {
        return listreview;
    }

    public void setListreview(List<Review> listreview) {
        this.listreview = listreview;
    }

    public List<Cart> getListcart() {
        return listcart;
    }

    public void setListcart(List<Cart> listcart) {
        this.listcart = listcart;
    }
}
