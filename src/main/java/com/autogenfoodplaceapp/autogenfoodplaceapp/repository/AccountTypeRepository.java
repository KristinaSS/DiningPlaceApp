package com.autogenfoodplaceapp.autogenfoodplaceapp.repository;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
}
