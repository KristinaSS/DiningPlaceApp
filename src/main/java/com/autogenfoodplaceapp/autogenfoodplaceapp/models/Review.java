package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@EnableJpaRepositories
@Entity
public class Review implements Comparable<Review>{
    private Integer reviewID;
    private Integer foodPlaceID;
    private Integer accountID;
    private Float foodRating;
    private Float valueRating;
    private Float overallRating;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    public Integer getReviewID() {
        return reviewID;
    }

    public void setReviewID(Integer reviewID) {
        this.reviewID = reviewID;
    }

    @Basic
    @Column(name = "food_place_id")
    public Integer getFoodPlaceID() {
        return foodPlaceID;
    }

    public void setFoodPlaceID(Integer foodPlaceID) {
        this.foodPlaceID = foodPlaceID;
    }

    @Basic
    @Column(name = "account_id")
    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    @Basic
    @Column(name = "food_rating")
    public Float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(Float foodRating) {
        this.foodRating = foodRating;
    }

    @Basic
    @Column(name = "value_rating")
    public Float getValueRating() {
        return valueRating;
    }

    public void setValueRating(Float valueRating) {
        this.valueRating = valueRating;
    }

    @Basic
    @Column(name = "overal_rating")
    public Float getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Float overallRating) {
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

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", foodPlaceID=" + foodPlaceID +
                ", accountID=" + accountID +
                ", foodRating=" + foodRating +
                ", valueRating=" + valueRating +
                ", overallRating=" + overallRating +
                ", description='" + description + '\'' +
                '}';
    }
}
