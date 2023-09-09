package com.example.city_center_entry.repository;

import com.example.city_center_entry.entity.PurposeOfEntryEnum;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PurposeOfEntryEnumRepository {
    private List<PurposeOfEntryEnum> data;

    public PurposeOfEntryEnumRepository(){
        data = new ArrayList<>();
        data.add(new PurposeOfEntryEnum(1, "Trvalé bydlisko"));
        data.add(new PurposeOfEntryEnum(2, "Trvalé bydlisko ročné"));
        data.add(new PurposeOfEntryEnum(3, "Zásobovanie"));
        data.add(new PurposeOfEntryEnum(4, "Vlastníctvo nehnuteľnosti"));
        data.add(new PurposeOfEntryEnum(5, "Zamestnanec"));
    }

    public List<PurposeOfEntryEnum> loadEnum() {
        return data;
    }

    public PurposeOfEntryEnum getById(int id) {
        return data.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
    }
}
