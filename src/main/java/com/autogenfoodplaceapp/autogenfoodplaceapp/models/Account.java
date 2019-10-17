package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity(name = "account")
public class Account implements Serializable {
    private int accID;
    private AccountType accountType;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private float minRating;
    private List<Review> reviewList = new ArrayList<>();

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    FoodPlaceRepository foodPlaceRepository;

    private Map<FoodPlace,Float> foodPlaceRating = new TreeMap<>();
    {
        FoodPlace lastFoodPlace = null;
        FoodPlace currFoodPlace;
        int numberReviews = 0;


        for(Review review: reviewRepository.findAll()) {
            if (review.getAccountID() != this.getAccID()) continue;
            currFoodPlace=foodPlaceRepository.getOne(review.getFoodPlaceID());
            if (lastFoodPlace != null){
                if(foodPlaceRating.containsKey(lastFoodPlace)){
                    foodPlaceRating.replace(lastFoodPlace,foodPlaceRating.get(lastFoodPlace)+currFoodPlace.getOverallRating());
                }else {
                    foodPlaceRating.replace(lastFoodPlace,(foodPlaceRating.get(lastFoodPlace)/numberReviews));
                    numberReviews = 0;
                }
            }
            lastFoodPlace = currFoodPlace;
            numberReviews++;


        }
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "review",
            joinColumns = {
                    @JoinColumn(name = "account_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "food_place_id", nullable = false, updatable = false)
            })
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_type_id")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "minimum_rating")
    public float getMinRating() {
        return minRating;
    }

    public void setMinRating(float minRating) {
        this.minRating = minRating;
    }

    public Map<FoodPlace, Float> getFoodPlaceRating() {
        return foodPlaceRating;
    }
}
