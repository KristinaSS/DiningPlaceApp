package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements IReviewServices {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getOne(int Id) {
        return reviewRepository.getOne(Id);
    }

    @Override
    public Review createOne(Review review, int foodPlaceId, int accId) {
        review.setAccountID(accId);
        review.setFoodPlaceID(foodPlaceId);
        return reviewRepository.save(review);
    }
}
