package com.example.customactionbar;

public class rcp_main_today_list {
    private Integer iconDrawable ;
    private String titleStr ;
    private String descStr ;

    public rcp_main_today_list(Integer iconDrawable, String titleStr, String descStr){
        this.iconDrawable = iconDrawable;
        this.titleStr = titleStr;
        this.descStr = descStr;
    }

    public void setIcon(Integer icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }

    public Integer getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
}
