package com.example.plantsearching.Model;

import java.io.Serializable;

public class Species implements Serializable {
    private String title;
    private  String kingdom;
    private  String image;
    private  String family;
    private  String description;

    public Species() {
    }

    public Species(String title, String kingdom, String image, String family, String description) {
        this.title = title;
        this.kingdom = kingdom;
        this.image = image;
        this.family = family;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
