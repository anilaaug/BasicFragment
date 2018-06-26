package com.example.anila.basicfragment.model;

public class Data {
    public int imageId;
    public String txt;

   public Data( int imageId, String text) {

        this.imageId = imageId;
        this.txt=text;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTxt() {
        return txt;
    }
}

