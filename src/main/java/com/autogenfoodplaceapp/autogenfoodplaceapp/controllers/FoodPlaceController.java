package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes.FoodPlaceServices;
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

    @PostMapping("/createFoodPlace")
    public FoodPlace createFoodPlace(@Valid @RequestBody FoodPlace foodPlace) {
        return foodPlaceServices.createOne(foodPlace);
    }
    @GetMapping("/auto-foodplace-acc-{accID}")
    public FoodPlace autoGenFoodPlace(@PathVariable(value = "accID") Integer accID){
        return foodPlaceServices.generateFoodPlace(accID);
    }
}
