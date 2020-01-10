package com.aakriti.hamrobazar.model;

public class TrendingAds {

    private String name;
    private  String price;
    private  String type;
    private String imaget;

    public TrendingAds(String name, String price, String type, String imaget) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.imaget = imaget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImaget() {
        return imaget;
    }

    public void setImaget(String imaget) {
        this.imaget = imaget;
    }
}
