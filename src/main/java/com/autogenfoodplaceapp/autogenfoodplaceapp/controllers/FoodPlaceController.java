package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes.FoodPlaceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class FoodPlaceController {
    @Autowired
    FoodPlaceServices foodPlaceServices;

    @GetMapping("/foodPlace")
    @ResponseStatus(HttpStatus.FOUND)
    public List<FoodPlace> getAllFoodPlaces() {
        return foodPlaceServices.findAll();
    }

    @PostMapping("/createFoodPlace")
    @ResponseStatus(HttpStatus.CREATED)
    public FoodPlace createFoodPlace(@Valid @RequestBody FoodPlace foodPlace) {
        return foodPlaceServices.createOne(foodPlace);
    }

    @GetMapping("/auto-foodplace-acc-{accID}")
    @ResponseStatus(HttpStatus.FOUND)
    public FoodPlace autoGenFoodPlace(@PathVariable(value = "accID") Integer accID) {
        return foodPlaceServices.generateFoodPlace(accID);
    }

    @DeleteMapping("/delete-foodplace-{fpID}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteFoodplace(@PathVariable(value = "fpID") Integer foodPlaceID) {
        foodPlaceServices.deleteByID(foodPlaceID);
    }
    @PutMapping("/edit-foodplace-{fpID}")
    @ResponseStatus(HttpStatus.OK)
    public FoodPlace updateAccount(@PathVariable(value = "fpID") Integer ID,
                                 @Valid @RequestBody FoodPlace foodPlace){
        return foodPlaceServices.updateByID(ID,foodPlace);
    }
}
