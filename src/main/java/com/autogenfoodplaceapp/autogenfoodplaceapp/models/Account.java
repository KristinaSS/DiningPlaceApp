package com.autogenfoodplaceapp.autogenfoodplaceapp.models;

import com.autogenfoodplaceapp.autogenfoodplaceapp.utils.MD5;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "account")
public class Account implements Serializable {


    private static final long serialVersionUID = 7695450117825003302L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accID;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    @Basic
    @Column(name = "first_name")
    @NotNull
    @Size(min = 4, max = 50)
    private String firstName;

    @Basic
    @Column(name = "last_name")
    @NotNull
    @Size(min = 4, max = 50)
    private String lastName;

    @Basic
    @Column(name = "email", nullable = false)
    @NotNull
    @Size(min = 4, max = 100)
    private String email;

    @Basic
    @Column(name = "password", nullable = false)
    @NotNull
    @Size(min = 4, max = 50)
    private transient String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    @JsonIgnoreProperties("account")
    private List<Review> reviewList = new ArrayList<>();

    public void setPassword(String password) {
        this.password = MD5.getHashString(password);
    }

    /*    public Account(@NonNull AccountType accountType,
                   @NonNull String firstName,
                   @NonNull String lastName,
                   @NonNull String email,
                   @NonNull String password) {
        this.accountType = accountType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Account(@NonNull String firstName,
                   @NonNull String lastName,
                   @NonNull String email,
                   @NonNull String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }*/
}
