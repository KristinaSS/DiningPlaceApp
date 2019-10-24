package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@EnableJpaRepositories
@Entity
public class Review implements Comparable<Review> {
    private Integer reviewID;
    private FoodPlace foodPlace;
    private Account account;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_place_id", nullable = false)
    @JsonIgnoreProperties("reviewList")
    public FoodPlace getFoodPlace() {
        return foodPlace;
    }

    public void setFoodPlace(FoodPlace foodPlace) {
        this.foodPlace = foodPlace;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnoreProperties("reviewList")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        return Float.compare(this.foodPlace.getFoodPlaceID(), review.getFoodPlace().getFoodPlaceID());
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", foodPlaceID=" + foodPlace.getFoodPlaceID() +
                ", accountID=" + account.getAccID() +
                ", foodRating=" + foodRating +
                ", valueRating=" + valueRating +
                ", overallRating=" + overallRating +
                ", description='" + description + '\'' +
                '}';
    }
}
