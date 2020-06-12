package com.example.customactionbar;

public class Rcp_item_list {
    private Integer iconDrawable ;
    private String titleStr ;

    public Rcp_item_list(Integer iconDrawable, String titleStr, String descStr){
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
