package nus.iss.laps.service;

import java.util.List;

import nus.iss.laps.model.Claim;
import nus.iss.laps.model.LeaveTypes;

public interface LeaveTypeService {
	public LeaveTypes findComp();
	public List<LeaveTypes> findAll();
}
