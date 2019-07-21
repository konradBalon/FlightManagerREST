package com.balondev.MenedzerLotow.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristDAO extends JpaRepository<Tourist,Long> {
    public  Tourist findTouristById(long id);
}
