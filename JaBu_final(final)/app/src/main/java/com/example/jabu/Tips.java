package com.example.jabu;

import java.io.Serializable;

public class Tips implements Serializable, Comparable<Tips> {

    public String tipHashtag;
    public String tipID;
    public String tipImage;
    public String tipReference;
    public String tipText;
    public String tipTitle;
    public Integer tipLikeN;

    public Tips (Tips tip){

        this.tipHashtag = tip.tipHashtag;
        this.tipID = tip.tipID;
        this.tipImage = tip.tipImage;
        this.tipReference = tip.tipReference;
        this.tipText = tip.tipText;
        this.tipTitle = tip.tipTitle;
        this.tipLikeN = tip.tipLikeN;
    }

    public String getTipHashtag() {
        return tipHashtag;
    }

    public void setTipHashtag(String tipHashtag) {
        this.tipHashtag = tipHashtag;
    }

    public String getTipID() {
        return tipID;
    }

    public void setTipID(String tipID) {
        this.tipID = tipID;
    }

    public String getTipImage() {
        return tipImage;
    }

    public void setTipImage(String tipImage) {
        this.tipImage = tipImage;
    }

    public String getTipReference() {
        return tipReference;
    }

    public void setTipReference(String tipReference) {
        this.tipReference = tipReference;
    }

    public String getTipText() {
        return tipText;
    }

    public void setTipText(String tipText) {
        this.tipText = tipText;
    }

    public String getTipTitle() {
        return tipTitle;
    }

    public void setTipTitle(String tipTitle) {
        this.tipTitle = tipTitle;
    }

    public Integer getTipLikeN() {
        return tipLikeN;
    }

    public void setTipLikeN(Integer tipLikeN) {
        this.tipLikeN = tipLikeN;
    }

    public Tips()
    {

    }
    public Tips(String tipHashtag, String tipID, String tipImage, String tipReference, String tipText, String tipTitle, Integer tipLikeN){
        this.tipHashtag = tipHashtag;
        this.tipID = tipID;
        this.tipImage = tipImage;
        this.tipReference = tipReference;
        this.tipText = tipText;
        this.tipTitle = tipTitle;
        this.tipLikeN = tipLikeN;
    }

    @Override
    public int compareTo(Tips o) {
        if (this.tipLikeN > o.tipLikeN) {
            return -1;
        } else if (this.tipLikeN == o.tipLikeN) {
            return 0;
        } else {
            return 1;
        }
    }
}
