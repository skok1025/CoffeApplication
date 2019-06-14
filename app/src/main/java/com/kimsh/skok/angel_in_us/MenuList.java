package com.kimsh.skok.angel_in_us;

import java.util.ArrayList;

public abstract class MenuList {
    private ArrayList<Object> MenuArrayList = new ArrayList<>();

    public void add(Object o){
        MenuArrayList.add(o);
    }

    public Object get(int index){
        return MenuArrayList.get(index);
    }

    public int length(){
        return MenuArrayList.size();
    }
}
