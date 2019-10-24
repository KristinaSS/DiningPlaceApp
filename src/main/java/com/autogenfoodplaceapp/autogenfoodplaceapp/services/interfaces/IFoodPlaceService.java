package com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;

public interface IFoodPlaceService extends Service<FoodPlace> {
    FoodPlace generateFoodPlace(int accID);
}
