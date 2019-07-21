package com.balondev.MenedzerLotow.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDAO extends JpaRepository<Flight,Long> {
    public Flight findFlightById(long id);
}
