package com.example.myapplication.ui.main;

public class item_list {
    private Integer iconDrawable ;
    private String titleStr ;

    public item_list(Integer iconDrawable, String titleStr){
        this.iconDrawable = iconDrawable;
        this.titleStr = titleStr;
    }

    public void setIcon(Integer icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }

    public Integer getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
}
