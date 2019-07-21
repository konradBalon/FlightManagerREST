package com.balondev.MenedzerLotow.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tourist {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String gender;
    private String country;
    private String notes;
    private int dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID")
     private  Flight flight;
    public Tourist(){};

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Tourist(long id, String name, String surname, String gender, String country, String notes, int dateOfBirth, Flight flight) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.country = country;
        this.notes = notes;
        this.dateOfBirth = dateOfBirth;
        this.flight=flight;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
