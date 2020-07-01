package com.example.jabu;

public class item_list {
    private Integer iconDrawable ;
    private String titleStr ;
    private String id;

    public item_list(Integer iconDrawable, String titleStr, String id){
        this.iconDrawable = iconDrawable;
        this.titleStr = titleStr;
        this.id = id;
    }

    public void setIcon(Integer icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setId(String id) {
        this.id = id ;
    }

    public Integer getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getId(){
        return this.id;
    }
}
