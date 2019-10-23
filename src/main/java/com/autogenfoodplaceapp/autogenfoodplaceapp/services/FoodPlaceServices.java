package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodPlaceServices implements IFoodPlaceService{
    @Autowired
    private FoodPlaceRepository foodPlaceRepository;

    @Override
    public List<FoodPlace> findAll() {
        return foodPlaceRepository.findAll();
    }

    @Override
    public FoodPlace getOne(int Id) {
        return foodPlaceRepository.getOne(Id);
    }

    @Override
    public FoodPlace createOne(FoodPlace foodPlace) {
        return foodPlaceRepository.save(foodPlace);
    }
}
