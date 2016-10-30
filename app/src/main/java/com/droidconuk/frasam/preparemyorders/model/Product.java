package com.droidconuk.frasam.preparemyorders.model;

import java.io.Serializable;

/**
 * Created by francescoditrani on 29/10/16.
 */

public class Product implements Serializable{

    private String name;
    private Double price;
    private String title;
    private String description;
    private String barcode;

    public Product() {
    }

    public Product(String name, Double price, String title, String description, String barcode) {
        this.name = name;
        this.price = price;
        this.title = title;
        this.description = description;
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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
