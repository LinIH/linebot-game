package com.example.rpgame.action;

import com.example.rpgame.CommandParam;

public class CharacterActionHandler {

    public void signUp(){
        System.out.println("sign up");
    }

    public void showStatus(){
        System.out.println("show status");
    }

    public void showBackpack(){
        System.out.println("show backpack");
    }

    public void useItem(CommandParam commandParam){
        System.out.println("use item" + commandParam.getItem());
    }

    public void equip(){
        System.out.println("equip");
    }

    public void unequipped(){
        System.out.println("unequipped");
    }

    public void manufacture(){
        System.out.println("manufacture");
    }

    public void missionCheck(){
        System.out.println("mission check");
    }

    public void showHelp(){
        System.out.println("show help");
    }
}
