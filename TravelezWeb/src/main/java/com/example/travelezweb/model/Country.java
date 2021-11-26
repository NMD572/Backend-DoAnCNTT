
package com.example.travelezweb.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="image",length = 65535,columnDefinition="Text")
    private String image;
    @Column(name="link",length = 65535,columnDefinition="Text")
    private String link;
    public Country() {

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Country(String name, String image, String link) {
        this.name = name;
        this.image = image;
        this.link = link;
    }
}
