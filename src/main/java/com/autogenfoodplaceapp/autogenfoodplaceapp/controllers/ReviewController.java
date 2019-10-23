package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @PostMapping("/reviews:acc-{accId}&food-place{foodPlaceId}")
    public Review createReview(@Valid @RequestBody Review review,
                                    @PathVariable(value = "accId") Integer accID,
                                    @PathVariable(value = "foodPlaceId") Integer foodPlaceId) {
        return reviewService.createOne(review,foodPlaceId,accID);
    }
}
