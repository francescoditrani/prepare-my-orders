package com.droidconuk.frasam.preparemyorders.model;

/**
 * Created by francescoditrani on 29/10/16.
 */

public class Product {

    String name;
    Double price;
    String title;
    String description;

    public Product(String name, Double price, String title, String description) {
        this.name = name;
        this.price = price;
        this.title = title;
        this.description = description;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
