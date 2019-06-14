package com.kimsh.skok.angel_in_us;

import java.util.ArrayList;

public class NonCoffeeMenuList extends MenuList{
    private ArrayList<NonCoffeeMenu> nonCoffeeMenuArrayList = new ArrayList<>();

    public void add(NonCoffeeMenu nonCoffeeMenu){
        nonCoffeeMenuArrayList.add(nonCoffeeMenu);
    }


    public NonCoffeeMenu get(int index){
        return nonCoffeeMenuArrayList.get(index);
    }

    public int length(){
        return nonCoffeeMenuArrayList.size();
    }
}
