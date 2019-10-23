package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;

import java.util.List;

public interface IFoodPlaceService {
    List<FoodPlace> findAll();

    FoodPlace getOne(int Id);

    FoodPlace createOne(FoodPlace foodPlace);
}
