package com.example.jabu;

public class Main_ViewPager_rcp_today_list {
    private Integer iconDrawable ;
    private String titleStr ;
    private String descStr ;
    private String id;



    public Main_ViewPager_rcp_today_list(Integer iconDrawable, String titleStr, String descStr, String id){
        this.iconDrawable = iconDrawable;
        this.titleStr = titleStr;
        this.descStr = descStr;
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
