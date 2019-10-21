package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "foodplace")
public class FoodPlace implements Comparable<FoodPlace>{
    private Integer foodPlaceID;
    private String name;
    private String address;
    private String telephone;
    private String linkToWebsite;
    private Float foodRating;
    private Float valueRating;
    private Float overallRating;


    private List<Review> reviewList = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_place_id")
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_place_id")
    public Integer getFoodPlaceID() {
        return foodPlaceID;
    }

    public void setFoodPlaceID(Integer foodPlaceID) {
        this.foodPlaceID = foodPlaceID;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "link_to_website")
    public String getLinkToWebsite() {
        return linkToWebsite;
    }

    public void setLinkToWebsite(String linkToWebsite) {
        this.linkToWebsite = linkToWebsite;
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
    @Column(name = "overall_rating")
    public Float getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Float overallRating) {
        this.overallRating = overallRating;
    }

    @Override
    public int compareTo(FoodPlace o) {
        return (this.name.compareTo(o.getName()));
    }
}
