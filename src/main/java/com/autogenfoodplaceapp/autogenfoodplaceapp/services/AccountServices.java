package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.ReviewRepository;
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

    /*public Map<FoodPlace, Float> getAllReviewOverallScoresMap(List<Review> filteredReviewList){
        List<Review> temp = new ArrayList<>();
        float tempScore = 0;
        Review tempReview= null;

        Map <FoodPlace, Float> foodPlace_accOverallRating = new HashMap<>();

        for(Review review: filteredReviewList){


            if(tempReview!= null) {
                if(tempReview.getFoodPlaceID() == review.getFoodPlaceID()){
                    temp.add(review);
                }else{
                    tempScore = getAverageOverallRating(temp);
                    foodPlace_accOverallRating.put(foodPlaceRepository.getOne(review.getFoodPlaceID()),tempScore);
                    temp.clear();
                }
            }
            else {
                temp.add(review);
            }
            tempReview = review;
        }
        return foodPlace_accOverallRating;
    }
*/
    public float getSumAllFoodPlaceRatings(Map<FoodPlace, Float> foodPlaceFloatMap){
        float sumAllValues = 0;
        for(Entry<FoodPlace, Float> entry: foodPlaceFloatMap.entrySet()){
            sumAllValues+= entry.getValue();
        }
        return sumAllValues;
    }

    /*public Map<FoodPlace, Float> getSortedFoodPlaceMap(Map <FoodPlace, Float> notSortedMap){
        return notSortedMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }
    */
    public FoodPlace getAutoGenFoodPlace(Account account, float randomRes){
        for (Entry<FoodPlace, Float> entry: account.getFoodPlaceRating().entrySet()){
            randomRes -= entry.getValue();
            if(randomRes <= 0){
                return entry.getKey();
            }
        }
        return null;
    }

    public int generateFoodPlace(int accID){
        Account account = accountRepository.getOne(accID);
        //List<Review> filteredReviewList = getAllReviewsWithMinRating(account.getReviewList(),account.getMinRating());
        //Collections.sort(filteredReviewList);

        //Map <FoodPlace, Float> foodPlace_accOverallRating = getAllReviewOverallScoresMap(filteredReviewList);

        Random random = new Random();

        float sumAllScores = getSumAllFoodPlaceRatings(account.getFoodPlaceRating());

        float randomRes = random.nextFloat()*sumAllScores;

        //Map <FoodPlace, Float> sorted_foodPlace_accOverallRating = getSortedFoodPlaceMap(foodPlace_accOverallRating);

        FoodPlace foodPlace = getAutoGenFoodPlace(account,randomRes);

        return foodPlace==null?-1:foodPlace.getFoodPlaceID();
    }

    /*public List<Review> getAllReviewsWithMinRating (List<Review> reviewList, float minRating){
        List<Review> reviews = new ArrayList<>();

        for (Review review : reviewList) {
            if (review.getOverallRating()>= minRating) {
                reviews.add(review);
            }
        }
        return reviews;
    }
*/
    /*public float getAverageOverallRating(List<Review> reviews){
        float average = 0;
        for (Review review: reviews){
            average += review.getOverallRating();
        }
        return average/reviews.size();
    }
*/
}
