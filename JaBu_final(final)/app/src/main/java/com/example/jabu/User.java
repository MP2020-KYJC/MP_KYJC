package com.example.jabu;
import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {

    public String myId;
    public String myPassword;
    public String myName;
    public String myViews;
    public String myLikes;
    public String myScraps;
    public String myHashtag;
    public String myMemo; //장보기 메모

    public User() {

    }

    public User(String myId, String myPassword, String myName, String myHashtag) {

        this.myId = myId;
        this.myPassword = myPassword;
        this.myName = myName;
        this.myHashtag = myHashtag;
    }

    public User(String myId, String myPassword, String myName, String myViews, String myLikes, String myScraps, String myMemo) {

        this.myId = myId;
        this.myPassword = myPassword;
        this.myName = myName;
        this.myViews = myViews;
        this.myLikes = myLikes;
        this.myScraps = myScraps;
        this.myMemo = myMemo;
    }

    public String getmyId()
    {
        return myId;
    }

    public void setmyId(String myId)
    {
        this.myId = myId;
    }

    public String getmyPassword()
    {
        return myPassword;
    }

    public void setmyPassword(String myPassword)
    {
        this.myPassword = myPassword;
    }

    public String getMyName()
    {
        return myName;
    }

    public void setMyName(String myName)
    {
        this.myName = myName;
    }

    public String getMyViews()
    {
        return myViews;
    }

    public void setMyViews(String myViews)
    {
        this.myViews = myViews;
    }

    public String getMyLikes()
    {
        return myLikes;
    }

    public void setMyLikes(String myLikes)
    {
        this.myLikes = myLikes;
    }


    public String getMyScraps()
    {
        return myScraps;
    }

    public void setMyScraps(String myScraps)
    {
        this.myScraps = myScraps;
    }

    public String getMyMemo()
    {
        return myMemo;
    }

    public void setMyMemo(String myMemo)
    {
        this.myMemo = myMemo;
    }

    public String getMyHashtag()
    {
        return myHashtag;
    }

    public void setMyHashtag(String myHashtag)
    {
        this.myHashtag = myHashtag;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +"myId='"+myId+'\''+ "myPassword='"+myPassword+'\''+"myName='" + myName + '\'' + "myViews='" + myViews + '\'' + ", myLikes='" + myLikes + '\'' +
                ", ='" +  + '\'' + ", myScraps='" + myScraps + '\'' + ", myMemo='" + myMemo + '\'' + '}';
    }

}
