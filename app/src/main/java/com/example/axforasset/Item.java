package com.example.axforasset;

public class Item {

    private String name;
    private String price;
    private String description;
    private int imageResourceId;

    public Item(String name, String price, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;

    private int imageResource;
    private String title;
    private String description;
    private double price;

    public Item(int imageResource, String title, String description, double price) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
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


    public int getImageResourceId() {
        return imageResourceId;

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }
}
