package nus.iss.laps.service;

import java.util.List;

import nus.iss.laps.exceptions.ClaimNotFound;
import nus.iss.laps.model.Claim;
import nus.iss.laps.model.Staff;



public interface ClaimService {
	public Claim create(Claim c);
	public List<Claim> findAll();
	public int findStaffId(String userid);
	public Double findTotalOTHours(int staffid);

	public List<Claim> findClaimsOfStaff(int staffid);
	public Claim update(Claim c) throws ClaimNotFound;
	public Claim findById(int leaveId);
	public Claim delete(Claim d) throws ClaimNotFound;
	//public List findLeaveNames();
}
