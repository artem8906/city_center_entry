package com.example.city_center_entry.model;

import com.example.city_center_entry.entity.PurposeOfEntryEnum;
import com.example.city_center_entry.entity.StreetsEnum;
import com.example.city_center_entry.enums.TypeOfPerson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntryRequestForm {
    private TypeOfPerson typeOfPerson;
    private String name; // meno a priezvisko / názov spoločnosti
    private String identifier; // IČO / RČ
    private String phone;
    private String address; // adresa tvraleho pobytu/sidlo poskytovateľa
    private String email;
    private String ecv;
    private float weightOfCar;
    private String factoryBrand;
    private PurposeOfEntryEnum purposeOfEntry;
    private boolean parking;
    private int parkingStreetId;
    // TODO: 8. 9. 2023
    /*private Date arriveDateTime;
    private Date leaveDateTime;
    private int daysCount;*/
}
