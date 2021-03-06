package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "foodplace")
public class FoodPlace implements Comparable<FoodPlace>, Serializable {

    private static final long serialVersionUID = -3321850516259460195L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_place_id")
    private Integer foodPlaceID;

    @Basic
    @Column(name = "name")
    @NotNull
    @Size(min = 4, max = 50)
    private String name;

    @Basic
    @Column(name = "address")
    @NotNull
    @Size(min = 4, max = 50)
    private String address;

    @Basic
    @Column(name = "telephone")
    private String telephone;

    @Basic
    @Column(name = "link_to_website")
    private String linkToWebsite;

    @Basic
    @Column(name = "food_rating")
    private Float foodRating;

    @Basic
    @Column(name = "value_rating")
    private Float valueRating;

    @Basic
    @Column(name = "overall_rating")
    private Float overallRating;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER, mappedBy = "foodPlace")
    @JsonIgnoreProperties("foodPlace")
    private List<Review> reviewList = new ArrayList<>();

    @Override
    public int compareTo(FoodPlace o) {
        return (this.name.compareTo(o.getName()));
    }
}
