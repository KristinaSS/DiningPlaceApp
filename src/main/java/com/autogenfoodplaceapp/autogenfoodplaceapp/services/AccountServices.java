package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.Map.Entry;
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

/*    public List<Review> getAllAccountReviews(int accID, float minRating){
        List<Review> reviews = new ArrayList<>();
        for (Review review :
                reviewRepository.findAll()) {
            if (review.getAccountID() == accID && review.getOverallRating() >= minRating) {
                reviews.add(review);
            }
        }
        return reviews;
    }*/

    public int generateFoodPlace(int accID){
        Account account = accountRepository.getOne(accID);
        List<Review> filteredReviewList = getAllReviewsWithMinRating(account.getReviewList(),account.getMinRating());
        Map <FoodPlace, Float> foodPlace_accOverallRating = new HashMap<>();
        float sumAllScores = 0;


        Collections.sort(filteredReviewList);

        List<Review> temp = new ArrayList<>();
        float tempScore = 0;
        Review tempReview= null;

        for(Review review: filteredReviewList){
            if(tempReview!= null) {
                if(tempReview.getFoodPlaceID() == review.getFoodPlaceID()){
                    temp.add(review);
                }else{
                    tempScore = getAverageOverallRating(temp);
                    foodPlace_accOverallRating.put(foodPlaceRepository.getOne(review.getFoodPlaceID()),tempScore);
                    temp.clear();
                    sumAllScores += tempScore;
                }
            }
            else {
                temp.add(review);
            }
            tempReview = review;
        }

        Random random = new Random();

        float randomRes = random.nextFloat()*sumAllScores;

/*        Map <FoodPlace, Float> sorted_foodPlace_accOverallRating = new HashMap<>();
        sorted_foodPlace_accOverallRating = foodPlace_accOverallRating
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.)*/
return 0;
    }

    public List<Review> getAllReviewsWithMinRating (List<Review> reviewList, float minRating){
        List<Review> reviews = new ArrayList<>();

        for (Review review : reviewList) {
            if (review.getOverallRating()>= minRating) {
                reviews.add(review);
            }
        }
        return reviews;
    }

    public float getAverageOverallRating(List<Review> reviews){
        float average = 0;
        for (Review review: reviews){
            average += review.getOverallRating();
        }
        return average/reviews.size();
    }

}
