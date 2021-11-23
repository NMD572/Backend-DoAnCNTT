
package com.example.travelezweb.model;

import com.sun.istack.NotNull;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")

    private String name;
    @Column(name = "brief")
    private String brief;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private String price;
    @Column(name = "quality")
    private int quality;
    @Column(name = "idtourguy")
    private int idtourguy;
    @Column(name = "maxmember")
    private int maxmember;
    @Column(name = "country")
    private String country;
    @Column(name = "time")
    private int time;

    public Tour() {

    }

    public Tour( String name, String brief, String description, String price, int quality, int idtourguy, int maxmember, String country, int time) {

        this.name = name;
        this.brief = brief;
        this.description = description;
        this.price = price;
        this.quality = quality;
        this.idtourguy = idtourguy;
        this.maxmember = maxmember;
        this.country = country;
        this.time = time;
    }

    public void setId(long id) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getIdtourguy() {
        return idtourguy;
    }

    public void setIdtourguy(int idtourguy) {
        this.idtourguy = idtourguy;
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

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", idtourguy=" + idtourguy +
                ", maxmember=" + maxmember +
                ", country='" + country + '\'' +
                ", time=" + time +
                '}';
    }



}
