package nus.iss.laps.service;

import java.util.List;

import nus.iss.laps.exceptions.StaffNotFound;
import nus.iss.laps.model.Staff;


public interface StaffService {
	public int findStaffDetails(String userid);
	public Staff update(Staff staffdet);
	public Staff findById(int staffid);
	public Staff updateCompOff(double noOfDays,int staffid);
	public List<Staff> findAll();
	public Staff delete(int id) throws StaffNotFound;
	public Staff create(Staff s);
	public Staff updateAll(Staff s) throws StaffNotFound;
	public Staff updateTotalOT(double oldOT,double newOT,Staff staff_det) throws StaffNotFound;
	//public Staff findByStaffid(int staffid);
}
