package com.example.city_center_entry.model;

import com.example.city_center_entry.entity.PurposeOfEntryEnum;
import com.example.city_center_entry.entity.StreetsEnum;
import com.example.city_center_entry.enums.TypeOfPerson;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class EntryRequestForm {
    private TypeOfPerson typeOfPerson;
    private String name; // meno a priezvisko / názov spoločnosti
    private String identifier; // IČO / RČ
    private String phone;
    private String address; // adresa tvraleho pobytu/sidlo poskytovateľa
    private String email;
    private String ECV;
    private int weightOfCar;
    private String factoryBrand;
    private PurposeOfEntryEnum purposeOfEntry;
    private boolean parking;
    private StreetsEnum parkingStreet;
    private Date arriveDateTime;
    private Date leaveDateTime;
    private int daysCount;
    private List<MultipartFile> files;
}
