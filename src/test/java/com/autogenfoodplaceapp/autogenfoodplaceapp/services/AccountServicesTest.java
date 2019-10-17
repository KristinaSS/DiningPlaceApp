package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class AccountServicesTest extends AccountServices{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    FoodPlaceRepository foodPlaceRepository;


    @Test
    public void generateFoodPlaceTest() {
        AccountType accountType = new AccountType();
        accountType.setName("test");
        accountType.setAccountTypeID(1);

        Account account = new Account();
        account.setAccountType(accountType);
        account.setAccID(1);
        account.setEmail("test");
        account.setFirstName("test name");
        account.setLastName("test last");
        account.setMinRating(3);
        account.setPassword("test pass");

        FoodPlace foodPlace = new FoodPlace();
        foodPlace.setAddress("asvbs");
        foodPlace.setFoodPlaceID(1);
        foodPlace.setName("agdhgaghd");
        foodPlace.setOverallRating(3.6f);

        FoodPlace afoodPlace = new FoodPlace();
        afoodPlace.setAddress("asvbs");
        afoodPlace.setFoodPlaceID(2);
        afoodPlace.setName("agdhgaghd");
        afoodPlace.setOverallRating(4.1f);

        Review review = new Review();
        review.setFoodPlaceID(foodPlace.getFoodPlaceID());
        review.setAccountID(account.getAccID());
        review.setOverallRating(foodPlace.getOverallRating());

        Review review1 = new Review();
        review1.setFoodPlaceID(afoodPlace.getFoodPlaceID());
        review1.setAccountID(account.getAccID());
        review1.setOverallRating(afoodPlace.getOverallRating());

        account.getReviewList().add(review);
        account.getReviewList().add(review1);

        //assertEquals(generateFoodPlace(account),2);
    }

    @Test
    public void findAccount1() {

    }

    @Test
    public void isAuthorizedtoEnterAccount1() {
    }

    @Test
    public void getSumAllFoodPlaceRatings1() {
    }

    @Test
    public void getAutoGenFoodPlace1() {
    }

    @Test
    public void generateFoodPlace1() {
    }
}