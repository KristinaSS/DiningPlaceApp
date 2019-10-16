package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
}
