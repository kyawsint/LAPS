package nus.iss.laps.service;

import java.util.List;

import nus.iss.laps.exceptions.OverTimeNotFound;
import nus.iss.laps.model.Claim;
import nus.iss.laps.model.OverTime;

public interface OverTimeService {
public OverTime create(OverTime overtime);
public List<OverTime> ListOfStaffOT(int staffid);
public OverTime findById(int otid);
public OverTime update(OverTime overtime);
public OverTime delete(OverTime overTime) throws OverTimeNotFound;
}
