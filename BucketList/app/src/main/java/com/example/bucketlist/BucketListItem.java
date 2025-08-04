package com.example.bucketlist;

public class BucketListItem {
    String title;
    String description;
    int image;
    float rating;

    public BucketListItem(String title, String description, int image, float rating) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.rating = rating;
    }
}
