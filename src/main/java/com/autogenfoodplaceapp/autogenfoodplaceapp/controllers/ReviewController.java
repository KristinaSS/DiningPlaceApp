package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private FoodPlaceRepository foodPlaceRepository;


    @GetMapping("/reviews")
    public List<Review> getAllAccountTypes() {
        return reviewRepository.findAllByReviewIDIsGreaterThan(0);
    }

    @PostMapping("/reviews:acc-{accId}&food-place{foodPlaceId}")
    public Review createAccountType(@Valid @RequestBody Review review,
                                    @PathVariable(value = "accId") Integer accID,
                                    @PathVariable(value = "foodPlaceId") Integer foodPlaceId) {
        review.setAccountID(accountRepository.getOne(accID).getAccID());
        review.setFoodPlaceID(foodPlaceRepository.getOne(foodPlaceId).getFoodPlaceID());

        return reviewRepository.save(review);
    }
}
