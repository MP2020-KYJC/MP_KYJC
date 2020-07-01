package com.example.jabu;

import java.io.Serializable;

public class Hashtags implements Serializable {

    public String htID;
    public String htLikes;
    public String htName;
    public String htScraps;

    public Hashtags(Hashtags hash) {
        this.htID = hash.htID;
        this.htLikes = hash.htLikes;
        this.htName = hash.htName;
        this.htScraps = hash.htScraps;
    }

    public String getHtID() {
        return htID;
    }

    public void setHtID(String htID) {
        this.htID = htID;
    }

    public String getHtLikes() {
        return htLikes;
    }

    public void setHtLikes(String htLikes) {
        this.htLikes = htLikes;
    }

    public String getHtName() {
        return htName;
    }

    public void setHtName(String htName) {
        this.htName = htName;
    }

    public String getHtScraps() {
        return htScraps;
    }

    public void setHtScraps(String htScraps) {
        this.htScraps = htScraps;
    }

    public Hashtags() {

    }

    public Hashtags(String htID, String htLikes, String htName, String htScraps) {
        this.htID = htID;
        this.htID = htLikes;
        this.htName = htName;
        this.htScraps = htScraps;
    }

}
