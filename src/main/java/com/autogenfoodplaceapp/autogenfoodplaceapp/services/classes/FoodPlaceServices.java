package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.exceptions.ResourceNotFoundException;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IFoodPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class FoodPlaceServices implements IFoodPlaceService {
    @Autowired
    private FoodPlaceRepository foodPlaceRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<FoodPlace> findAll() {
        return foodPlaceRepository.findAll();
    }

    @Override
    public FoodPlace getOne(int Id) {
        return foodPlaceRepository.getOne(Id);
    }

    @Override
    public FoodPlace createOne(FoodPlace foodPlace) {
        return foodPlaceRepository.save(foodPlace);
    }

    @Override
    public FoodPlace generateFoodPlace(int accID) {
        Account account = accountRepository.getOne(accID);

        Map<FoodPlace, Float> foodRatings =
                fillFoodPlaceRatingMap(account, reviewRepository.findAll());

        Random random = new Random();

        float sumAllScores = getSumAllFoodPlaceRatings(foodRatings);

        float randomRes = random.nextFloat() * sumAllScores;

        return getFoodPlace(randomRes, foodRatings);
    }

    @Override
    public void deleteByID(int foodPlaceID) {
        foodPlaceRepository.delete(getOne(foodPlaceID));
    }

    @Override
    public FoodPlace updateByID(int ID, FoodPlace updatedFoodPlace) {
        return foodPlaceRepository.findById(ID)
                .map(foodPlace -> foodPlaceRepository.save(updatedFoodPlaceMembers(foodPlace,updatedFoodPlace)))
                .orElseGet(()->{
                    try {
                        throw new ResourceNotFoundException("A Food Place with this Id has not been found:  "+ ID);
                    } catch (ResourceNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    private Map<FoodPlace, Float> fillFoodPlaceRatingMap(Account account, List<Review> notSortedReviews) {
        FoodPlace lastFoodPlace = null;
        FoodPlace currFoodPlace;
        int numberReviews = 0;
        Map<FoodPlace, Float> foodPlaceRating = new TreeMap<>();

        //sort ratings by food Places
        List<Review> sortedReviews = notSortedReviews.stream().sorted().collect(Collectors.toList());

        for (Review review : sortedReviews) {
            //reviews of only the current account
            if (!review.getAccount().getAccID().equals(account.getAccID())) continue;

            currFoodPlace = foodPlaceRepository.getOne(review.getFoodPlace().getFoodPlaceID());

            if (lastFoodPlace != null) {
                if (currFoodPlace.getFoodPlaceID().equals(lastFoodPlace.getFoodPlaceID())) {
                    foodPlaceRating.replace(currFoodPlace, foodPlaceRating.get(currFoodPlace) + review.getOverallRating());
                } else {
                    foodPlaceRating.replace(lastFoodPlace, foodPlaceRating.get(lastFoodPlace) / numberReviews);
                    numberReviews = 0;

                    foodPlaceRating.put(currFoodPlace, review.getOverallRating());
                }
            } else
                foodPlaceRating.put(currFoodPlace, review.getOverallRating());

            lastFoodPlace = currFoodPlace;
            numberReviews++;
        }
        return foodPlaceRating;
    }

    private float getSumAllFoodPlaceRatings(Map<FoodPlace, Float> foodPlaceFloatMap) {
        float sumAllValues = 0;
        for (Map.Entry<FoodPlace, Float> entry : foodPlaceFloatMap.entrySet()) {
            sumAllValues += entry.getValue();
        }
        return sumAllValues;
    }

    private FoodPlace getFoodPlace(float randomRes, Map<FoodPlace, Float> foodPlaceFloatMap) {
        for (Map.Entry<FoodPlace, Float> entry : foodPlaceFloatMap.entrySet()) {
            randomRes -= entry.getValue();
            if (randomRes <= 0) {
                return entry.getKey();
            }
        }
        return null;
    }

    private FoodPlace updatedFoodPlaceMembers(FoodPlace foodPlace, FoodPlace updatedFoodPlace){
        foodPlace.setName(updatedFoodPlace.getName());
        foodPlace.setAddress(updatedFoodPlace.getAddress());
        foodPlace.setTelephone(updatedFoodPlace.getTelephone());
        foodPlace.setLinkToWebsite(updatedFoodPlace.getLinkToWebsite());
        return foodPlace;
    }
}
