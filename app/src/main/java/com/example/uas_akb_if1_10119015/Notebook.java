package com.example.uas_akb_if1_10119015;

/*
    Nama    : Agi Sutrisna
    Nim     : 10119015
    Kelas   : IF1
 */

public class Notebook {

    private long ID;
    private String title;
    private String category;
    private String content;
    private String date;
    private String time;

    public Notebook(){ }
    public Notebook(String title, String content, String category, String date, String time){
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
        this.time = time;
    }
    public Notebook(long id, String title, String content, String category, String date, String time){
        this.ID = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
        this.time = time;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

