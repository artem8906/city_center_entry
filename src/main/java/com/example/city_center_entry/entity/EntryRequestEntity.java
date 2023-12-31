package com.example.city_center_entry.entity;

import com.example.city_center_entry.enums.RequestStatus;
import com.example.city_center_entry.enums.TypeOfPerson;
import lombok.Data;

@Data
public class EntryRequestEntity {
    private int id;
    private UserEntity user;
    private TypeOfPerson typeOfPerson;
    private String name;
    private String identifier;
    private String phone;
    private String address;
    private String email;
    private String ecv;
    private float weightOfCar;
    private String factoryBrand;
    private PurposeOfEntryEnum purposeOfEntry;
    private boolean parking;
    private StreetsEnum parkingStreet;
    private RequestStatus status;
    // TODO: 8. 9. 2023
}
