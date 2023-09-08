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

    private final List<String> aimOfEntry = new ArrayList<>();


    public Car(String licencePlate, String owner, String aimOfEntry) {
        this.lisencePlate = licencePlate;
        this.owner = new Owner(owner);
        this.dateOfRegister = new Date();
        this.aimOfEntry.add(aimOfEntry);
    }

    public List<String> getAimOfEntry() {
        return aimOfEntry;
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
