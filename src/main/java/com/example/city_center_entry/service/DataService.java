package com.example.city_center_entry.service;

import com.example.city_center_entry.entity.Auto;
import com.example.city_center_entry.entity.Entry;
import com.example.city_center_entry.entity.PointEntryExit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataService {

    private final Map<String, Auto> repository = new HashMap<>();

    private final List<Entry> listOfClosedEntryes = new ArrayList<>();

    private final List<Entry> listOfOpenEntryes = new ArrayList<>();

    private final List<PointEntryExit> pointEntryExitList = new ArrayList<>();
    //fill list of all entry point
    {
        pointEntryExitList.add(new PointEntryExit(0));
        pointEntryExitList.add(new PointEntryExit(1));
        pointEntryExitList.add(new PointEntryExit(2));
        pointEntryExitList.add(new PointEntryExit(3));
    }
    //add new auto to list allowed to entry
    public Auto addNewAuto (Auto auto) {
        return repository.put(auto.getLisencePlate(), auto);
    }

    //remove auto from list of allowed to entry
    public Auto removeAuto (Auto auto) {
        return repository.remove(auto.getLisencePlate());
    }
    //change lisence plate in list of allowed to entry
    public void changeAuto (String oldPlate, String newPlate, String newOwner) {
        repository.put(oldPlate, new Auto(newPlate, newOwner));
    }

    // add list of cars to list of allowed cars
    public void addFewCars(List<Auto> list) {
        for (Auto auto: list) {
            repository.put(auto.getLisencePlate(), auto);
        }
    }

    // get auto from allowed list if exist, if no - return null
    public Auto get(String plate) {
        return repository.get(plate);
    }
    //when auto enters it adds entry to list
    public void addOpenEntry(Entry entry) {
        listOfOpenEntryes.add(entry);
    }
    //if auto already entered it return entry, if no - return null
    public Entry getOpenEntry(String lisencePlate) {
        return listOfOpenEntryes.stream().
                filter(e -> e.getAuto().getLisencePlate().equals(lisencePlate))
                .findFirst()
                .get();

    }

    // return PointEntry based on ID
    public PointEntryExit getEntryPoint(int gateID) {
        return pointEntryExitList.get(gateID);
    }
}
