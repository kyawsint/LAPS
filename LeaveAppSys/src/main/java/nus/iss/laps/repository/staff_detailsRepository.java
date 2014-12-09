package nus.iss.laps.repository;


import nus.iss.laps.model.staff_details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface staff_detailsRepository  extends JpaRepository<staff_details,Integer>{

}
