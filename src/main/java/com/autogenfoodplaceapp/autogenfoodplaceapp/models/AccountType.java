package com.autogenfoodplaceapp.autogenfoodplaceapp.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity(name = "account_type")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_type_id")
    private int accountTypeID;

    @Basic
    @Column(name = "name")
    private String name;


/*    private List<Account> accountList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "account_type_id")
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }*/
}
