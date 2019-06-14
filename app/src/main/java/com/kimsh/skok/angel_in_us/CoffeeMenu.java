package com.kimsh.skok.angel_in_us;

public class CoffeeMenu {
    private String name;
    private int smallPrice;
    private int regularPrice;
    private int largePrice;
    private Integer imagePath;
    public CoffeeMenu(String name, int smallPrice, int regularPrice, int largePrice, Integer imagePath){
        this.name = name;
        this.smallPrice = smallPrice;
        this.regularPrice = regularPrice;
        this.largePrice = largePrice;
        this.imagePath =imagePath;
    }

    public String getName() {
        return name;
    }

    public int getSmallPrice() {
        return smallPrice;
    }

    public int getRegularPrice(){
        return regularPrice;
    }

    public int getLargePrice(){
        return largePrice;
    }

    public Integer getImagePath() {
        return imagePath;
    }
}
