package com.balondev.MenedzerLotow;

import com.balondev.MenedzerLotow.Entity.Flight;
import com.balondev.MenedzerLotow.Entity.FlightDAO;
import com.balondev.MenedzerLotow.Entity.Tourist;
import com.balondev.MenedzerLotow.Entity.TouristDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TouristController {

    private TouristDAO touristDAO;
    private FlightDAO flightDAO;

    @Autowired
    public TouristController(TouristDAO touristDAO, FlightDAO flightDAO) {
        this.touristDAO = touristDAO;
        this.flightDAO = flightDAO;
    }


    @RequestMapping(value = "/tourist/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void dodaj(@RequestBody Tourist tourist) {


        touristDAO.save(tourist);

    }

    @RequestMapping(value = "/flight/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void dodaj(@RequestBody Flight flight) {


        flightDAO.save(flight);
    }


    @RequestMapping(value = "tourist/assignFlight/{touristId}/{flightId}", method = RequestMethod.PATCH)
    public String change(@PathVariable("touristId") long touristId, @PathVariable("flightId") long flightId) {
        if (touristDAO.findTouristById(touristId) != null && flightDAO.findFlightById(flightId) != null) {
            Tourist tourist = touristDAO.findTouristById(touristId);
            Flight flight = flightDAO.findFlightById(flightId);
            tourist.addFlight(flight);
            flight.addTourist(tourist);
            flight.setAmountOfFPlaces(flight.getAmountOfFPlaces() - 1);
            touristDAO.save(tourist);
            flightDAO.save(flight);

        } else return "nie ma takiego numeru";
        return "przypisano lot o id = " + flightId + " do turysty o id = " + touristId;
    }
    @RequestMapping(value = "/tourist/{id}", method = RequestMethod.GET)
    public Tourist printTourist(@PathVariable("id") long id) {
        return touristDAO.findTouristById(id);
    }
    @RequestMapping(value = "/flight/{id}", method = RequestMethod.GET)
    public Flight printFlight(@PathVariable("id") long id) {
        return flightDAO.findFlightById(id);
    }

    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public List<Flight> wy() {
        return flightDAO.findAll();
    }

    @RequestMapping(value = "/tourists", method = RequestMethod.GET)
    public List<Tourist> napisz() {
        return touristDAO.findAll();
    }

    @RequestMapping(value = "/tourist/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) {
        Tourist tourist = touristDAO.findTouristById(id);
        touristDAO.delete(tourist);
    }

    @RequestMapping(value = "/flight/delete/{id}", method = RequestMethod.DELETE)
    public void deleteFlight(@PathVariable("id") long id) {
        Flight flight = flightDAO.findFlightById(id);
        flightDAO.delete(flight);
    }

}

