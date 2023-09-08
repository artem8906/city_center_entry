package com.example.city_center_entry.entity;

import com.example.city_center_entry.enums.TypeOfPerson;
import lombok.Data;

@Data
public class User {
    private int id;
    private String login;
    private String password;

    private TypeOfPerson typeOfPerson;
    private String name;
    private String identifier;
    private String phone;
    private String address;
    private String email;
    private String ecv;
    private float weightOfCar;
    private String factoryBrand;
}
