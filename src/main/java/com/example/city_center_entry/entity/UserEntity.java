package com.example.city_center_entry.entity;

import com.example.city_center_entry.enums.TypeOfPerson;
import com.example.city_center_entry.model.EntryRequestForm;
import lombok.Data;

@Data
public class UserEntity {
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

    public EntryRequestForm toEntryRequest() {
        EntryRequestForm result = new EntryRequestForm();
        result.setTypeOfPerson(typeOfPerson);
        result.setName(name);
        result.setIdentifier(identifier);
        result.setPhone(phone);
        result.setAddress(address);
        result.setEmail(email);
        result.setEcv(ecv);
        result.setWeightOfCar(weightOfCar);
        result.setFactoryBrand(factoryBrand );
        return result;
    }
}
