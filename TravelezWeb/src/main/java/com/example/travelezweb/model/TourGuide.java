package com.example.travelezweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name="brief", length = 1000)
    private String brief;
    @Column(name="fblink",length = 65535,columnDefinition="Text")
    private String fbLink;
    @Column(name="instagramlink",length = 65535,columnDefinition="Text")
    private String instagramLink;
    @Column(name="image",length = 65535,columnDefinition="Text")
    private String image;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tourguide")
    @JsonManagedReference
    private List<Tour> listTour = new ArrayList<>();
    public TourGuide(){

    }

    public TourGuide(String name, double quality, String brief, String fbLink, String instagramLink, String image) {
        this.name = name;
        this.quality = quality;
        this.brief = brief;
        this.fbLink = fbLink;
        this.instagramLink = instagramLink;
        this.image = image;
    }

    public TourGuide(String name, double quality, String brief, String fbLink, String instagramLink, String image, List<Tour> listTour) {
        this.name = name;
        this.quality = quality;
        this.brief = brief;
        this.fbLink = fbLink;
        this.instagramLink = instagramLink;
        this.image = image;
        this.listTour = listTour;
    }

    public TourGuide(int id, String name, double quality, String brief, String fbLink, String instagramLink, String image, List<Tour> listTour) {
        this.id = id;
        this.name = name;
        this.quality = quality;
        this.brief = brief;
        this.fbLink = fbLink;
        this.instagramLink = instagramLink;
        this.image = image;
        this.listTour = listTour;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getFbLink() {
        return fbLink;
    }

    public void setFbLink(String fbLink) {
        this.fbLink = fbLink;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Tour> getListTour() {
        return listTour;
    }

    public void setListTour(List<Tour> listTour) {
        this.listTour = listTour;
    }
}
