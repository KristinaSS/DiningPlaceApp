package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getOne(int Id) {
        return accountRepository.getOne(Id);
    }

    @Override
    public Account createOne(Account account, int accType) {
        account.setAccountType(accountTypeRepository.getOne(accType));
        return accountRepository.save(account);
    }



/*
    private Map<FoodPlace,Float> foodPlaceRating = new TreeMap<>();

    public void fillFoodPlaceRatingMap(Account account){
        FoodPlace lastFoodPlace = null;
        FoodPlace currFoodPlace;
        int numberReviews = 0;

        //List<Review> sortedReviewRepository = reviewRepository.findAllByReviewIDIsGreaterThan(0);

        Collections.sort(AccountController.REVIEWS);

        for(Review review: AccountController.REVIEWS) {
            if (!review.getAccountID().equals(account.getAccID())) continue;
            currFoodPlace= AccountController.FOOD_PLACES.stream().filter(x -> x.getFoodPlaceID().equals(review.getFoodPlaceID())).findFirst().get();

            if (lastFoodPlace != null){
                System.out.println("1");
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
    }*/

    //not used yet

/*    public int findAccount(String email){
        for(Account account: accountRepository.findAll()){
            if(account.getEmail().equals(email)){
                return account.getAccID();
            }       }
        return -1;
    }

    public boolean isAuthorizedtoEnterAccount(int accID, String password){
        return accountRepository.getOne(accID).getPassword().equals(password);
    }*/
}
