package com.example.city_center_entry.entity;

import java.util.Date;

public class Entry {

    private Car car;
    private Date dateOfEntry;
    private Date dateOfExit;
    private PointEntryExit pointEntry;
    private PointEntryExit pointExit;


    public Car getAuto() {
        return car;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public Date getDateOfExit() {
        return dateOfExit;
    }

    public PointEntryExit getPointEntry() {
        return pointEntry;
    }

    public PointEntryExit getPointExit() {
        return pointExit;
    }

    public void setDateOfExit(Date dateOfExit) {
        this.dateOfExit = dateOfExit;
    }

    public void setPointExit(PointEntryExit pointExit) {
        this.pointExit = pointExit;
    }

    public Entry(Car car, Date dateOfEntry, PointEntryExit pointEntry) {
        this.car = car;
        this.dateOfEntry = dateOfEntry;
        this.pointEntry = pointEntry;
    }
}


