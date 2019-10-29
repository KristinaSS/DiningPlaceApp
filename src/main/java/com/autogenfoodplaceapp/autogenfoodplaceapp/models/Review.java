package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EnableJpaRepositories
@Entity
public class Review implements Comparable<Review> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_place_id", nullable = false)
    @JsonIgnoreProperties("reviewList")
    private FoodPlace foodPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnoreProperties("reviewList")
    private Account account;

    @Basic
    @Column(name = "food_rating")
    private Float foodRating;

    @Basic
    @Column(name = "value_rating")
    private Float valueRating;

    @Basic
    @Column(name = "overal_rating")
    private Float overallRating;

    @Basic
    @Column(name = "description")
    private String description;

    @Override
    public int compareTo(Review review) {
        return Float.compare(this.foodPlace.getFoodPlaceID(), review.getFoodPlace().getFoodPlaceID());
    }
}
