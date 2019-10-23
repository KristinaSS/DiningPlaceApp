package com.autogenfoodplaceapp.autogenfoodplaceapp.repository;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
