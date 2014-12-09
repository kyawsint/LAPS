package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.laps.model.Leave_Details;
import nus.iss.laps.repository.LeaveHistoryRepository;

@Service
public class LeaveHistoryServiceImp implements LeaveHistoryService {

	@Resource
	private LeaveHistoryRepository leavehistoryRepos;
	
	@Override
	@Transactional
	public List<Leave_Details> findByStaffID(int staffid) {
		
		return leavehistoryRepos.findByStaffID(staffid);
	}

	@Override
	@Transactional
	public Leave_Details findByID(int leaveID) {
		return leavehistoryRepos.findOne(leaveID);
	}

	@Override
	@Transactional
	public List<Leave_Details> findAll() {
		return leavehistoryRepos.findAll();
	}

	@Override
	@Transactional
	public Leave_Details update(Leave_Details ld) {
			Leave_Details updateLeave = leavehistoryRepos.findOne(ld.getLeaveID());
			updateLeave.setLeaveStatus(ld.getLeaveStatus());
			leavehistoryRepos.flush();
		return updateLeave;
	}
	
	@Override
	@Transactional
	public List<Leave_Details> findByLeaveTypeID(int leaveTypeID){
		return leavehistoryRepos.findByLeaveTypeID(leaveTypeID);
	}
}
