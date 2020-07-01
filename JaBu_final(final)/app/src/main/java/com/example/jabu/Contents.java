package com.example.jabu;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Contents implements Serializable, Comparable<Contents> {

    public String ctID;
    public String ctTitle;
    public String ctIg;
    public String ctText;
    public String ctImage;
    public Integer ctLikeN;
    public String ctReference;
    public String ctHashtag;

    public Contents() {

    }

    public Contents(Contents contents) {
        this.ctID = contents.ctID;
        this.ctTitle = contents.ctTitle;
        this.ctIg = contents.ctIg;
        this.ctText = contents.ctText;
        this.ctImage = contents.ctImage;
        this.ctReference = contents.ctReference;
        this.ctHashtag = contents.ctHashtag;
        this.ctLikeN = contents.ctLikeN;
    }

    public Contents(String ctID, String ctTitle, String ctIg, String ctText, String ctImage, String ctReference, String ctHashtag, Integer ctLikeN) {

        this.ctID = ctID;
        this.ctTitle = ctTitle;
        this.ctIg = ctIg;
        this.ctText = ctText;
        this.ctImage = ctImage;
        this.ctReference = ctReference;
        this.ctHashtag = ctHashtag;
        this.ctLikeN = ctLikeN;
    }

    public String getCtID() {
        return ctID;
    }

    public void setCtID(String ctID) {
        this.ctID = ctID;
    }

    public String getCtTitle() {
        return ctTitle;
    }

    public void setCtTitle(String ctTitle) {
        this.ctTitle = ctTitle;
    }

    public String getCtIg() {
        return ctIg;
    }

    public void setCtIg(String ctIg) {
        this.ctIg = ctIg;
    }

    public String getCtText() {
        return ctText;
    }

    public void setCtText(String ctText) {
        this.ctText = ctText;
    }

    public String getCtImage() {
        return ctImage;
    }

    public void setCtImage(String ctImage) {
        this.ctImage = ctImage;
    }

    public String getCtReference() {
        return ctReference;
    }

    public void setCtReference(String ctReference) {
        this.ctReference = ctReference;
    }

    public String getCtHashtag() {
        return ctHashtag;
    }

    public void setCtHashtag(String ctHashtag) {
        this.ctHashtag = ctHashtag;
    }

    public Integer getCtLikeN() {
        return ctLikeN;
    }

    public void setCtLikeN(Integer ctLikeN) {
        this.ctLikeN = ctLikeN;
    }


    @NonNull
    @Override
    public String toString() {
        return "Contents{" + "ctID='" + ctID + '\'' + "ctTitle='" + ctTitle + '\'' + ", ctText='" + ctText + '\'' +
                ", ctImage='" + ctImage + '\'' + ", ctReference='" + ctReference + '\'' + "ctHashtag='" + ctHashtag + '\'' + '}';
    }

    @Override
    public int compareTo(Contents o) {
        if (this.ctLikeN > o.ctLikeN) {
            return -1;
        } else if (this.ctLikeN == o.ctLikeN) {
            return 0;
        } else {
            return 1;
        }
    }
}
