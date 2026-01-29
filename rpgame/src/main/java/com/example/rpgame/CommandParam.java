package com.example.rpgame;

public class CommandParam {
    private String command;
    private String item;
    private int count;

    CommandParam(String command, String item, int count){
        this.command = command;
        this.item = item;
        this.count = count;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
