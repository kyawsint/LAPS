package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import nus.iss.laps.exceptions.ClaimNotFound;
import nus.iss.laps.model.Claim;
import nus.iss.laps.model.LeaveTypes;
import nus.iss.laps.model.Login;
import nus.iss.laps.repository.ClaimRepository;







import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.laps.model.Claim;



@Service
public class ClaimServiceImpl implements ClaimService{
	@Resource
	private ClaimRepository claimRepository;

	@Override
	@Transactional
	public Claim create(Claim claim) {
		Claim createdClaim=claim;
		return claimRepository.save(createdClaim);
		
	}

	@Override
	@Transactional
	
	public List<Claim> findAll() {
		return claimRepository.findAll();
	}

	@Override
	public int findStaffId(String userid) {	
		return claimRepository.findStaffid(userid);
	}

	@Override
	public Double findTotalOTHours(int staffid) {
		return claimRepository.findTotalOTHours(staffid);
	}

	
	@Override
	public Claim findById(int leaveId){
		return claimRepository.findOne(leaveId);
	}

	@Override
	@Transactional(rollbackFor=ClaimNotFound.class)
	public Claim update(Claim c) throws ClaimNotFound{
		Claim updateClaim=claimRepository.findOne(c.getLeaveID());
		if(updateClaim==null){
			throw new ClaimNotFound();
		}
		updateClaim.setComments(c.getComments());
		updateClaim.setContactAddress(c.getContactAddress());
		updateClaim.setFromDate(c.getFromDate());
		updateClaim.setLeaveStatus(c.getLeaveStatus());
		updateClaim.setLeaveTypeID(c.getLeaveTypeID());
		updateClaim.setNoOfDays(c.getNoOfDays());
		updateClaim.setReasonForLeave(c.getReasonForLeave());
		updateClaim.setStaffID(c.getStaffID());
		claimRepository.flush();
		return updateClaim;
	}

	@Override
	@Transactional(rollbackFor=ClaimNotFound.class)
	public Claim delete(Claim c) throws ClaimNotFound {

		Claim deleteClaim=claimRepository.findOne(c.getLeaveID());
		if(deleteClaim==null){
			throw new ClaimNotFound();
		}
		deleteClaim.setLeaveStatus(c.getLeaveStatus());
		claimRepository.flush();
		return deleteClaim;	
	}

	@Override
	public List<Claim> findClaimsOfStaff(int staffid) {

		return claimRepository.findClaimsOfStaff(staffid);
		
	}

//	@Override
//	@Transactional
//	public List<LeaveTypes> findLeaveNames() {
//		// TODO Auto-generated method stub
//		return claimRepository.getLeaveNames();
//	}
	
	
}
