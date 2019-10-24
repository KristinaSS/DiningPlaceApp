package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @PostMapping("/reviews:acc-{accId}&food-place{foodPlaceId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@Valid @RequestBody Review review,
                               @PathVariable(value = "accId") Integer accID,
                               @PathVariable(value = "foodPlaceId") Integer foodPlaceId) {
        return reviewService.createOne(review, foodPlaceId, accID);
    }

    @PutMapping("/edit-review-{reviewID}")
    @ResponseStatus(HttpStatus.OK)
    public Review updateAccount(@PathVariable(value = "reviewID") Integer ID,
                                   @Valid @RequestBody Review review){
        return reviewService.updateByID(ID,review);
    }
}
