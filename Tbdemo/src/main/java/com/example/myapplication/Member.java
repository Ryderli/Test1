package com.example.myapplication;

/**
 * Created by Administrator on 2016/12/18 0018.
 */

public class Member {
    private int id;
    private int imageid;
    private String name;
    private String title1;
    private String title2;

    public Member(int id, int imageid, String name, String title1, String title2) {
        this.id = id;
        this.imageid = imageid;
        this.name = name;
        this.title1 = title1;
        this.title2 = title2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }
}
