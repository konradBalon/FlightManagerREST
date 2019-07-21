package com.balondev.MenedzerLotow.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private String arrivalDate;
    private String departureDate;
    private int amountOfFPlaces;
    private int price;
    private Tourist tourist;

    public Flight() {
    }

    public Flight(long id, String arrivalDate, String departureDate, int amountOfFPlaces, int price, Tourist tourist) {
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.amountOfFPlaces = amountOfFPlaces;
        this.price = price;
        this.tourist = tourist;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getAmountOfFPlaces() {
        return amountOfFPlaces;
    }

    public void setAmountOfFPlaces(int amountOfFPlaces) {
        this.amountOfFPlaces = amountOfFPlaces;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
