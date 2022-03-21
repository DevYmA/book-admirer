package com.yarch.booksadmirerservice.model;

public class AdmireFavourite {

    private String bookName;
    private String description;
    private int ratings;

    public AdmireFavourite(String userName, String description, int ratings) {
        this.bookName = userName;
        this.description = description;
        this.ratings = ratings;
    }

    public String getUserName() {
        return bookName;
    }

    public void setUserName(String userName) {
        this.bookName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
