package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import javax.persistence.*;

@Entity
public class Review implements Comparable<Review>{
    private int reviewID;
    private int foodPlaceID;
    private int accountID;
    private float foodRating;
    private float valueRating;
    private float overallRating;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    @Basic
    @Column(name = "food_place_id")
    public int getFoodPlaceID() {
        return foodPlaceID;
    }

    public void setFoodPlaceID(int foodPlaceID) {
        this.foodPlaceID = foodPlaceID;
    }

    @Basic
    @Column(name = "account_id")
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Basic
    @Column(name = "food_rating")
    public float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(float foodRating) {
        this.foodRating = foodRating;
    }

    @Basic
    @Column(name = "value_rating")
    public float getValueRating() {
        return valueRating;
    }

    public void setValueRating(float valueRating) {
        this.valueRating = valueRating;
    }

    @Basic
    @Column(name = "overal_rating")
    public float getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(float overallRating) {
        this.overallRating = overallRating;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Review review) {
        return Float.compare(this.foodPlaceID, review.getFoodPlaceID());
    }
}
