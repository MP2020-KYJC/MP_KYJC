package com.example.jabu;

public class Tip_list {
    private String titleStr ;
    private String id;

    public Tip_list( String titleStr, String id){
        this.titleStr = titleStr;
        this.id = id;
    }


    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setId(String id){this.id = id;}

    public String getTitle() {
        return this.titleStr ;
    }
    public String getId(){return this.id;}
}
