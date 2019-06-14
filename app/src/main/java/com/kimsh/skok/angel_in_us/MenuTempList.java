package com.kimsh.skok.angel_in_us;

import java.util.ArrayList;

public class MenuTempList {
    private ArrayList<MenuTemp> menuTempArrayList = new ArrayList<MenuTemp>();
    private int totalPrice=0;
    public void add(MenuTemp menuTemp){
        menuTempArrayList.add(menuTemp);
    }

    public MenuTemp get(int index){
        return menuTempArrayList.get(index);
    }

    public void clear(){
        menuTempArrayList.clear();
    }

    public String showList(){
        totalPrice = 0;
        String result = "===== 주문 내역 =====\n";
        for(int i =0;i<menuTempArrayList.size();i++){
            int onePrice = get(i).getPrice() * get(i).getCount();
            totalPrice += onePrice;
            result += get(i).getName()+" : "+get(i).getPrice()+"x"+get(i).getCount()+"="+onePrice+
                    " 추가:"+get(i).getOptionTemp().toString()+"\n";
        }
        result += "총액: "+totalPrice+"원";
        return  result;
    }

    public int getTotalPrice(){
        return  totalPrice;
    }

    public void setTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }



}
