package com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Service<T> {
    Logger LOGGER = LogManager.getLogger(Service.class);

    List<T> findAll();

    T getOne(int Id);

    T createOne(T entity);

    void deleteByID(int ID);

    T updateByID(int ID, T entity);
}
