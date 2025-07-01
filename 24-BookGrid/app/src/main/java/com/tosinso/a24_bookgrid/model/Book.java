package com.tosinso.a24_bookgrid.model;

public class Book {
    private String title;
    private int imageResourceId;
    private int descriptionResourceId;

    public Book(String title, int imageResourceId, int descriptionResourceId) {
        this.title = title;
        this.imageResourceId = imageResourceId;
        this.descriptionResourceId = descriptionResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getDescriptionResourceId() {
        return descriptionResourceId;
    }

    public void setDescriptionResourceId(int descriptionResourceId) {
        this.descriptionResourceId = descriptionResourceId;
    }
}
