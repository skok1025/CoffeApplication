package com.kimsh.skok.angel_in_us;

public class MenuTemp {

    private String name;
    private int price;
    private int count;
    private String option;

    public MenuTemp(String name,int price, int count,String option){
        this.name = name;
        this.price = price;
        this.count = count;
        this.option = option;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getCount(){
        return count;
    }

    public String getOptionTemp() {
        return option;
    }

    @Override
    public String toString() {
        return String.format("메뉴: %s, \n가격: %,d원, 개수:%,d개\n추가:%s",name,price,count,option);
    }
}
