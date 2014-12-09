package nus.iss.laps.service;

import java.util.List;

import nus.iss.laps.model.Leave;
import nus.iss.laps.model.Staff;

public interface LeaveService {
	public Leave create(Leave l); 
	public List<Leave> findAll();
	public Leave findById(long id);
	public Leave update(Leave l);
	public int findStaffId(String sName);
	public List<Leave> findByStaffId(long id);
}
