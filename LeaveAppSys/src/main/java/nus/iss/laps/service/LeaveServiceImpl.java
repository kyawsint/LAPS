package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import nus.iss.laps.model.Leave;
import nus.iss.laps.model.Staff;
import nus.iss.laps.repository.LeaveRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Resource
	private LeaveRepository lr;

	@Override
	@Transactional
	public Leave create(Leave l) {
		// TODO Auto-generated method stub
		Leave leavenew = l;
		return lr.save(leavenew);
	}

	@Override
	public List<Leave> findAll() {
		return (List<Leave>) lr.findAll();
	}
	
	@Override
	public Leave findById(long id) {
		return lr.findOne(id);
	}
	
	@Override
	public Leave update(Leave l)
	{
		Leave uLeave=lr.findOne(l.getLeaveId());

		uLeave.setStaffId(l.getStaffId());
		uLeave.setFromDate(l.getFromDate());
		uLeave.setNoOfDays(l.getNoOfDays());
		uLeave.setLeaveTypeId(l.getLeaveTypeId());
		uLeave.setLeaveStatus(l.getLeaveStatus());
		uLeave.setContactAddress(l.getContactAddress());
		uLeave.setComments(l.getComments());
		uLeave.setReasonForLeave(l.getReasonForLeave());
		lr.save(uLeave);
		return uLeave;
	}

	@Override
	public int findStaffId(String sName){
		return lr.findStaffid(sName);
	}
	
	@Override
	public List<Leave> findByStaffId(long staffId){
		return lr.findByStaff(staffId);
	}
}
