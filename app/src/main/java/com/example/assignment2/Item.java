package com.example.assignment2;

import java.io.Serializable;


public class Item implements Serializable{

    String name;
    String location;
    String phone;
    String description;
    String rating;

    public Item(String name, String location, String phone, String description, String rating) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.description = description;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }



}
