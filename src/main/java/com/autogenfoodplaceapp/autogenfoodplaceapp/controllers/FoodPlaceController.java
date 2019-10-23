package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.FoodPlaceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class FoodPlaceController {
    @Autowired
    FoodPlaceServices foodPlaceServices;

    @GetMapping("/foodPlace")
    public List<FoodPlace> getAllFoodPlaces() {
        return foodPlaceServices.findAll();
    }

    @PostMapping("/foodPlaceRepository")
    public FoodPlace createFoodPlace(@Valid @RequestBody FoodPlace foodPlace) {
        return foodPlaceServices.createOne(foodPlace);
    }
}
