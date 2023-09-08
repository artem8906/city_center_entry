package com.example.city_center_entry.entity;

import java.util.Date;

public class Entry {

    private Auto auto;
    private Date dateOfEntry;
    private Date dateOfExit;
    private PointEntryExit pointEntry;
    private PointEntryExit pointExit;


    public Auto getAuto() {
        return auto;
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

    public Entry(Auto auto, Date dateOfEntry, PointEntryExit pointEntry) {
        this.auto = auto;
        this.dateOfEntry = dateOfEntry;
        this.pointEntry = pointEntry;
    }
}


