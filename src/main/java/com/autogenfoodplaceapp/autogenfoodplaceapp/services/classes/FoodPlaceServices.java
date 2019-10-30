package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.exceptions.EntityNotFoundException;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IFoodPlaceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Log4j2
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
        return foodPlaceRepository.findById(Id).orElseGet(() -> {
            try {
                throw new EntityNotFoundException(FoodPlace.class);
            } catch (EntityNotFoundException e) {
                log.warn("A food place with this Id has not been found:  {}", Id);
            }
            return null;
        });
    }

    @Override
    public FoodPlace createOne(FoodPlace foodPlace) {
        log.info("New food place has been created: {}", foodPlace);
        return foodPlaceRepository.save(foodPlace);
    }

    @Override
    public FoodPlace generateFoodPlace(int accID) {
        Account account = accountRepository.findById(accID)
                .orElseGet(() -> {
                    try {
                        throw new EntityNotFoundException(Account.class);
                    } catch (EntityNotFoundException e) {
                        log.warn(" A account with this Id has not been found: {}", accID);
                    }
                    return null;
                });

        if (account == null) {
            log.warn("Cannot generate food place.");
            return null;
        }

        Map<FoodPlace, Float> foodRatings =
                fillFoodPlaceRatingMap(account, reviewRepository.findAll());

        Random random = new Random();

        float sumAllScores = getSumAllFoodPlaceRatings(foodRatings);

        float randomRes = random.nextFloat() * sumAllScores;

        return getFoodPlace(randomRes, foodRatings);
    }

    @Override
    public void deleteByID(int foodPlaceID) {
        FoodPlace foodPlace = getOne(foodPlaceID);
        if (foodPlace == null) {
            try {
                throw new EntityNotFoundException(FoodPlace.class);
            } catch (EntityNotFoundException e) {
                log.warn("A food place with this Id has not been found:  {}", foodPlaceID);
            }
            return;
        }
        log.info("Deleted food place with id: {}",foodPlaceID);
        foodPlaceRepository.delete(getOne(foodPlaceID));
    }

    @Override
    public FoodPlace updateByID(int ID, FoodPlace updatedFoodPlace) {
        return foodPlaceRepository.findById(ID)
                .map(foodPlace -> foodPlaceRepository.save(updatedFoodPlaceMembers(foodPlace, updatedFoodPlace)))
                .orElseGet(() -> {
                    try {
                        throw new EntityNotFoundException(FoodPlace.class);
                    } catch (EntityNotFoundException e) {
                        log.warn("A Food Place with this Id has not been found: {}" ,ID);
                    }
                    return null;
                });
    }

    private Map<FoodPlace, Float> fillFoodPlaceRatingMap(@NotNull Account account,
                                                         @NotNull List<Review> notSortedReviews) {
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

    private float getSumAllFoodPlaceRatings(@NotNull Map<FoodPlace, @NotNull Float> foodPlaceFloatMap) {
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

    private FoodPlace updatedFoodPlaceMembers(FoodPlace foodPlace, FoodPlace updatedFoodPlace) {
        foodPlace.setName(updatedFoodPlace.getName());
        foodPlace.setAddress(updatedFoodPlace.getAddress());
        foodPlace.setTelephone(updatedFoodPlace.getTelephone());
        foodPlace.setLinkToWebsite(updatedFoodPlace.getLinkToWebsite());
        log.info("Food place updated: {}", foodPlace);
        return foodPlace;
    }
}
