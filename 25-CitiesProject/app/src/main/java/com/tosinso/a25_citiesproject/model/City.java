package com.tosinso.a25_citiesproject.model;

public class City {
    private String title;
    private String description;
    private int imageId;

    public City(String title, String description, int imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }

    public City() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
