package com.example.city_center_entry.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
public class Car {

//    @ID
    private String lisencePlate;
    private Owner owner;
    private final Date dateOfRegister;


    public Car(String licencePlate, String owner) {
        this.lisencePlate = licencePlate;
        this.owner = new Owner(owner);
        this.dateOfRegister = new Date();
    }



    public String getLisencePlate() {
        return lisencePlate;
    }

    public Owner getOwner() {
        return owner;
    }

    public Date getDateOfRegister() {
        return dateOfRegister;
    }

}
