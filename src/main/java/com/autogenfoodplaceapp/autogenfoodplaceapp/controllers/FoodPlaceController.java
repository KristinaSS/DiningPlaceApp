package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes.FoodPlaceServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("")
public class FoodPlaceController {
    @Autowired
    FoodPlaceServices foodPlaceServices;

    @GetMapping("/foodPlace")
    @ResponseStatus(HttpStatus.OK)
    public List<FoodPlace> getAllFoodPlaces() {
        log.debug("REST request to get all FoodPlaces");
        return foodPlaceServices.findAll();
    }

    @PostMapping("/createFoodPlace")
    @ResponseStatus(HttpStatus.CREATED)
    public FoodPlace createFoodPlace(@Valid @RequestBody FoodPlace foodPlace) {
        log.debug("REST request to save FoodPlace : {}", foodPlace);
        return foodPlaceServices.createOne(foodPlace);
    }

    @GetMapping("/auto-foodplace-acc-{accID}")
    @ResponseStatus(HttpStatus.OK)
    public FoodPlace autoGenFoodPlace(@PathVariable(value = "accID") Integer accID) {
        log.debug("REST request to get generated FoodPlace from Account : {}", accID);
        return foodPlaceServices.generateFoodPlace(accID);
    }

    @DeleteMapping("/delete-foodplace-{fpID}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteFoodplace(@PathVariable(value = "fpID") Integer foodPlaceID) {
        log.debug("REST request to delete FoodPlace : {}", foodPlaceID);
        foodPlaceServices.deleteByID(foodPlaceID);
    }
    @PutMapping("/edit-foodplace-{fpID}")
    @ResponseStatus(HttpStatus.OK)
    public FoodPlace updateAccount(@PathVariable(value = "fpID") Integer ID,
                                 @Valid @RequestBody FoodPlace foodPlace){
        log.debug("REST request to update FoodPlace : {}", ID);
        return foodPlaceServices.updateByID(ID,foodPlace);
    }
}
