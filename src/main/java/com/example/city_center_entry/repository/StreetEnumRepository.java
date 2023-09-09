package com.example.city_center_entry.repository;

import com.example.city_center_entry.entity.StreetsEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StreetEnumRepository {

    private List<StreetsEnum> streets;

    public StreetEnumRepository() {
        streets = new ArrayList<>();
        streets.add(new StreetsEnum(1, "Michalská"));
        streets.add(new StreetsEnum(2, "Ventúrska"));
        streets.add(new StreetsEnum(3, "Sedlárska"));
        streets.add(new StreetsEnum(4, "Straková"));
        streets.add(new StreetsEnum(5, "Kapitulska"));
    }

    public List<StreetsEnum> nacitajUlice() {
        return streets;
    }

    public StreetsEnum najdiUlicuPodlaId(int id) {
        return streets.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
    }


}
