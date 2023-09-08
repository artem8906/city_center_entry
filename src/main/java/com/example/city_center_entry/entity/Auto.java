package com.example.city_center_entry.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
public class Auto {

//    @ID
    private String lisencePlate;
    private String owner;
    private final Date dateOfRegister;

    private static final String LICENCE_FORMAT = "\s(5)";


    public Auto(String licencePlate, String owner) {
        this.lisencePlate = licencePlate;
        this.owner = owner;
        this.dateOfRegister = new Date();
    }

    public static List<Auto> createFewAutos(String rangeOfLicensePlate, String owner) {//BA 100AA - BA 200AA
        List<Auto> list = new ArrayList<>();
        for (String s : rangeOfLicensePlate.split(" ")) {
            list.add(new Auto(s, owner));
        }
        return list;
    }



    public String getLisencePlate() {
        return lisencePlate;
    }

    public String getOwner() {
        return owner;
    }

    public Date getDateOfRegister() {
        return dateOfRegister;
    }

}
