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


    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void dodaj(@RequestBody Tourist tourist) {


        touristDAO.save(tourist);

    }

    @RequestMapping(value = "/addF", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void dodaj(@RequestBody Flight flight) {


        flightDAO.save(flight);
    }

    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public List<Flight> wy() {
        return flightDAO.findAll();
    }

    @RequestMapping(value = "/{touristId}/{flightId}", method = RequestMethod.PATCH)
    public void change(@PathVariable("touristId") long touristId, @PathVariable("flightId") long flightId) {
   Tourist tourist= touristDAO.findTouristById(touristId);
   Flight flight = flightDAO.findFlightById(flightId);
   tourist.addFlight(flight);
   touristDAO.save(tourist);

    }


    @RequestMapping(value = "/tourists", method = RequestMethod.GET)
    public List<Tourist> napisz() {
        return touristDAO.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) {
        Tourist tourist = touristDAO.findTouristById(id);
        touristDAO.delete(tourist);
    }

}

