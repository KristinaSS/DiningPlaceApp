package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.FoodPlaceRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.ReviewRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.FoodPlace;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Review;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("")
public class AccountController {
    public static final List<Account> ACCOUNTS = new ArrayList<>();
    public static final List<FoodPlace>FOOD_PLACES = new ArrayList<>();
    public static final List<AccountType> ACCOUNT_TYPES = new ArrayList<>();
    public static final List<Review> REVIEWS = new ArrayList<>();

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private FoodPlaceRepository foodPlaceRepository;

    @GetMapping("/account")
    public List<Account> getAllAccounts() {
        return accountRepository.findAccountsByAccIDGreaterThan(0);
    }

    @PostMapping("/account")
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }
    @PostMapping("/account/{typeId}")
    public Account createAccount(@Valid @RequestBody Account account,@PathVariable(value = "typeId") Integer typeId) {
        account.setAccountType(accountTypeRepository.getOne(typeId));
        return accountRepository.save(account);
    }

    @GetMapping("/account-gen-{AccId}")
    public FoodPlace generateFoodPlace(@PathVariable(value = "AccId") Integer accID) {
        Account account = accountRepository.getOne(accID);

        REVIEWS.clear();
        REVIEWS.addAll(reviewRepository.findAllByReviewIDIsGreaterThan(0));

        FOOD_PLACES.clear();
        FOOD_PLACES.addAll(foodPlaceRepository.findAll());

        return new AccountServices().generateFoodPlace(account);
    }
}