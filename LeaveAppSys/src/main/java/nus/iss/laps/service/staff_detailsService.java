package nus.iss.laps.service;

import java.util.List;

import nus.iss.laps.model.staff_details;

public interface staff_detailsService {
   public List<staff_details> findAll();
   public staff_details findByStaffid(int staffid);
   public void update(staff_details s);
}
