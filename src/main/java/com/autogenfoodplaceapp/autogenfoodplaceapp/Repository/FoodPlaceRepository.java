package com.autogenfoodplaceapp.autogenfoodplaceapp.Repository;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPlaceRepository extends JpaRepository<FoodPlace, Long> {
}
