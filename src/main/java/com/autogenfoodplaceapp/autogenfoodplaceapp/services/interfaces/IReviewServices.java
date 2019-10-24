package com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;


public interface IReviewServices extends Service<Review> {
    Review createOne(Review review, int foodPlaceId, int accId);
}
