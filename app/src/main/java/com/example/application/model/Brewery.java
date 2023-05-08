package com.example.application.model;

public class Brewery {

    public String name;
    public String brewery_type;
    public String address_1;
    public String country;
    public Long phone;
    public String website_url;

    public Brewery(String name, String brewery_type, String address_1, String country, Long phone, String website_url) {
        this.name = name;
        this.brewery_type = brewery_type;
        this.address_1 = address_1;
        this.country = country;
        this.phone = phone;
        this.website_url = website_url;
    }
}
