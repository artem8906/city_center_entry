package com.example.city_center_entry.repository;

import com.example.city_center_entry.entity.StreetsEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StreetEnumRepository {

    public List<StreetsEnum> nacitajUlice(){
        List<StreetsEnum> result = new ArrayList<>();
        result.add(new StreetsEnum(1, "Michalská"));
        result.add(new StreetsEnum(2, "Ventúrska"));
        result.add(new StreetsEnum(3, "Sedlárska"));
        result.add(new StreetsEnum(4, "Straková"));
        result.add(new StreetsEnum(5, "Kapitulska"));

        return result;
    }
}
