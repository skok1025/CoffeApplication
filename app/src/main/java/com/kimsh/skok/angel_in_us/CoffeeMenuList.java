package com.kimsh.skok.angel_in_us;

import java.util.ArrayList;

public class CoffeeMenuList extends MenuList  {

    private ArrayList<CoffeeMenu> coffeeMenuArrayList = new ArrayList<CoffeeMenu>();

    public void add(CoffeeMenu coffeeMenu){
        coffeeMenuArrayList.add(coffeeMenu);
    }

    public CoffeeMenu get(int index){
       return coffeeMenuArrayList.get(index);
    }

    public int length(){
        return coffeeMenuArrayList.size();
    }

}
