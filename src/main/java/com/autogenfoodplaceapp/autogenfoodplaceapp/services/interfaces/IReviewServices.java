package com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;

import java.util.List;

public interface IReviewServices {
    List<Review> findAll();

    Review getOne(int Id);

    Review createOne(Review review, int foodPlaceId, int accId);
}
