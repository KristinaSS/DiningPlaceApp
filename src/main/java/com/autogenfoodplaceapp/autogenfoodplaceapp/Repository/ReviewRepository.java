package com.autogenfoodplaceapp.autogenfoodplaceapp.Repository;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
