package com.kimsh.skok.angel_in_us;

public class OptionTemp {
    private boolean have_milk;
    private boolean have_whip;
    private boolean have_shot;

    public void Have_milk(boolean have_milk){
        this.have_milk = have_milk;
    }
    public void Have_whip(boolean have_whip){
        this.have_whip = have_whip;
    }
    public void Have_shot(boolean have_shot){
        this.have_shot =have_shot;
    }

    public boolean isHave_milk(){
        return have_milk;
    }

    public boolean isHave_whip(){
        return  have_whip;
    }

    public boolean isHave_shot(){
        return  have_shot;
    }


    @Override
    public String toString() {
        String options = "";
        if(have_milk){
            options +="+milk ";
        }
        if(have_whip){
            options +="+whip ";
        }
        if(have_shot){
            options +="+shot ";
        }
        return  options;
    }
}
