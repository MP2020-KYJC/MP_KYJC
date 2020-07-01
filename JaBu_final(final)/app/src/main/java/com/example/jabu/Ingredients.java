package com.example.jabu;

import java.io.Serializable;

public class Ingredients implements Serializable {

    public String igAddedDate;
    public String igExpiration;
    public String igID;
    public String igImage;
    public String igIsAdded;
    public String igName;

    public Ingredients ( Ingredients ingredients){
        this.igAddedDate = ingredients.igAddedDate;
        this.igExpiration = ingredients.igExpiration;
        this.igID = ingredients.igID;
        this.igImage = ingredients.igImage;
        this.igIsAdded = ingredients.igIsAdded;
        this.igName = ingredients.igName;
    }


    public String getIgAddedDate() {
        return igAddedDate;
    }

    public void setIgAddedDate(String igAddedDate) {
        this.igAddedDate = igAddedDate;
    }

    public String getIgExpiration() {
        return igExpiration;
    }

    public void setIgExpiration(String igExpiration) {
        this.igExpiration = igExpiration;
    }

    public String getIgID() {
        return igID;
    }

    public void setIgID(String igID) {
        this.igID = igID;
    }

    public String getIgImage() {
        return igImage;
    }

    public void setIgImage(String igImage) {
        this.igImage = igImage;
    }

    public String getIsIsAdded() {
        return igIsAdded;
    }

    public void setIsIsAdded(String isIsAdded) {
        this.igIsAdded = isIsAdded;
    }

    public String getIgName() {
        return igName;
    }

    public void setIgName(String igName) {
        this.igName = igName;
    }

    public Ingredients()
    {

    }
    public Ingredients(String igAddedDate, String igExpiration, String igID, String igImage, String isIsAdded, String igName){
        this.igAddedDate = igAddedDate;
        this.igExpiration = igExpiration;
        this.igID = igID;
        this.igImage = igImage;
        this.igIsAdded = isIsAdded;
        this.igName = igName;
    }
}
