package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "account")
public class Account implements Serializable {
    private Integer accID;
    private AccountType accountType;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Review> reviewList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "review",
            joinColumns = {
                    @JoinColumn(name = "account_id", nullable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "food_place_id", nullable = false)
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
    public Integer getAccID() {
        return accID;
    }

    public void setAccID(Integer accID) {
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
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
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
    @Override
    public String toString() {
        printReviewList();
        return "Account{" +
                "accID=" + accID +
                ", accountType=" + accountType.getName() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", reviewList=" + reviewList.size() +
                '}';
    }
    private void printReviewList(){
        for(Review r: reviewList){
            System.out.println(r);
        }
    }
}
