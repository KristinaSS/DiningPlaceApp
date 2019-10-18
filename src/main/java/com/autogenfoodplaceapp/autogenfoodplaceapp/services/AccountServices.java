package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.controllers.AccountController;
import com.autogenfoodplaceapp.autogenfoodplaceapp.controllers.FoodPlaceController;
import com.autogenfoodplaceapp.autogenfoodplaceapp.controllers.ReviewController;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class AccountServices {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    FoodPlaceRepository foodPlaceRepository;

    private Map<FoodPlace,Float> foodPlaceRating = new TreeMap<>();

    public void fillFoodPlaceRatingMap(Account account){
        FoodPlace lastFoodPlace = null;
        FoodPlace currFoodPlace;
        int numberReviews = 0;

        List<Review> sortedReviewRepository =
                reviewRepository.findAll().stream().collect(Collectors.toList());

        Collections.sort(sortedReviewRepository);

        for(Review review: sortedReviewRepository) {
            if (review.getAccountID() != account.getAccID()) continue;
            currFoodPlace=foodPlaceRepository.getOne(review.getFoodPlaceID());

            if (lastFoodPlace != null){
                if(foodPlaceRating.containsKey(lastFoodPlace)){
                    foodPlaceRating.replace(lastFoodPlace,foodPlaceRating.get(lastFoodPlace)+review.getOverallRating());
                }else {
                    foodPlaceRating.put(lastFoodPlace,(foodPlaceRating.get(lastFoodPlace)/numberReviews));
                    numberReviews = 0;
                }
            }else
                foodPlaceRating.put(currFoodPlace,review.getOverallRating());
            lastFoodPlace = currFoodPlace;
            numberReviews++;
        }
    }

    public float getSumAllFoodPlaceRatings(Map<FoodPlace, Float> foodPlaceFloatMap){
        float sumAllValues = 0;
        for(Entry<FoodPlace, Float> entry: foodPlaceFloatMap.entrySet()){
            sumAllValues+= entry.getValue();
        }
        return sumAllValues;
    }

    public FoodPlace getAutoGenFoodPlace(Account account, float randomRes){
        for (Entry<FoodPlace, Float> entry: getFoodPlaceRating().entrySet()){
            randomRes -= entry.getValue();
            if(randomRes <= 0){
                return entry.getKey();
            }
        }
        return null;
    }

    public FoodPlace generateFoodPlace(Account account){

        fillFoodPlaceRatingMap(account);

        Random random = new Random();

        float sumAllScores = getSumAllFoodPlaceRatings(getFoodPlaceRating());

        float randomRes = random.nextFloat()*sumAllScores;

        return getAutoGenFoodPlace(account,randomRes);
    }

    public Map<FoodPlace, Float> getFoodPlaceRating() {
        return foodPlaceRating;
    }

    //not used yet

    public int findAccount(String email){
        for(Account account: accountRepository.findAll()){
            if(account.getEmail().equals(email)){
                return account.getAccID();
            }       }
        return -1;
    }

    public boolean isAuthorizedtoEnterAccount(int accID, String password){
        return accountRepository.getOne(accID).getPassword().equals(password);
    }
}
