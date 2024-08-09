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
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
