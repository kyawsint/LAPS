package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.laps.model.LeaveTypes;
import nus.iss.laps.repository.ClaimRepository;
import nus.iss.laps.repository.LeaveTypeRepository;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService{

	@Resource
	private LeaveTypeRepository leaveTypeRepository;
	
	@Override
	public LeaveTypes findComp() {
		return leaveTypeRepository.findLeaveTypes();
	}

	@Override
	@Transactional
	public List<LeaveTypes> findAll(){
		return (List<LeaveTypes>) leaveTypeRepository.findAll();
	}
}
