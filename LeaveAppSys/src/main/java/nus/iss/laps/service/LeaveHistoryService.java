package nus.iss.laps.service;

import java.util.List;

import nus.iss.laps.model.Leave_Details;

public interface LeaveHistoryService {
	public Leave_Details findByID(int leaveID);
	public List<Leave_Details> findByStaffID(int staffid);
	public List<Leave_Details> findAll();
	public Leave_Details update(Leave_Details ld);
	public List<Leave_Details> findByLeaveTypeID(int leaveTypeID);
}
