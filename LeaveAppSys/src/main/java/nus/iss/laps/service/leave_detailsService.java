package nus.iss.laps.service;

import java.util.List;

import nus.iss.laps.model.Leave_Details;

public interface leave_detailsService {
   public List<Leave_Details> findAppendingLeave(String leaveStatus);
   public void updateStatus(String leaveStatus,int leaveID);
   public Leave_Details findByleaveID(int leaveID);
}
