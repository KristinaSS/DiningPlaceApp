package com.autogenfoodplaceapp.autogenfoodplaceapp;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoGenFoodPlaceAppApplication {

	public static void main(String[] args) {
//		Configuration configuration = new Configuration();
//
//		configuration.configure();
//
//		Session session = configuration.buildSessionFactory().openSession();
//
//		Transaction transaction = session.beginTransaction();
//		AccountType accountType = new AccountType();
//		accountType.setAccountTypeID(1);
//		accountType.setName("admin");
//
//		session.save(accountType);
//
//		if(transaction.isActive())
//			session.getTransaction().commit();
//
//		session.close();

		SpringApplication.run(AutoGenFoodPlaceAppApplication.class, args);
	}

}
