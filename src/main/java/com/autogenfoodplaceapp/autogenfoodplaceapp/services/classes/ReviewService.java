package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.exceptions.EntityNotFoundException;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IReviewServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
public class ReviewService implements IReviewServices {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FoodPlaceRepository foodPlaceRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getOne(int Id) {
        return reviewRepository.findById(Id) .orElseGet(()->{
            try {
                throw new EntityNotFoundException(Review.class);
            } catch (EntityNotFoundException e) {
                log.warn("A review with this Id has not been found:  {}", Id);
            }
            return null;
        });
    }

    @Override
    public void deleteByID(int ID) {
        Review review = getOne(ID);
        if(review == null) {
            try {
                throw new EntityNotFoundException(Review.class);
            } catch (EntityNotFoundException e) {
                log.warn("A review with this Id has not been found:  {}", ID);
            }
            return;
        }
        log.info("Deleted review with id: {}",ID);
        reviewRepository.delete(getOne(ID));
    }

    @Override
    public Review updateByID(int ID, Review updatedReview) {
        return reviewRepository.findById(ID)
                .map(review -> reviewRepository.save(updatedFoodPlaceMembers(review,updatedReview)))
                .orElseGet(()->{
                    try {
                        throw new EntityNotFoundException(Review.class);
                    } catch (EntityNotFoundException e) {
                        log.warn("A review with this Id has not been found:  {}", ID);
                    }
                    return null;
                });
    }

    private Review updatedFoodPlaceMembers(Review review, Review updatedReview) {
        review.setDescription(updatedReview.getDescription());
        review.setFoodRating(updatedReview.getFoodRating());
        review.setValueRating(updatedReview.getValueRating());
        review.setOverallRating(updatedReview.getOverallRating());
        log.info("Review updated: {}", review);
        return review;
    }

    @Override
    public Review createOne(Review review, int foodPlaceId, int accId) {
        review.setAccount(accountRepository.getOne(accId));
        review.setFoodPlace(foodPlaceRepository.getOne(foodPlaceId));
        log.info("New review has been created: {}", review);
        return reviewRepository.save(review);
    }

    //todo fix this
    @Override
    @Deprecated
    public Review createOne(Review entity) {
        return null;
    }
}
