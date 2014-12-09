package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.laps.exceptions.OverTimeNotFound;
import nus.iss.laps.model.Claim;
import nus.iss.laps.model.OverTime;
import nus.iss.laps.repository.OverTimeRepository;

@Service
public class OverTimeServiceImpl implements OverTimeService{

	@Resource
	private OverTimeRepository overTimeRepository;
	@Override
	@Transactional
	public OverTime create(OverTime overtime) {
		OverTime ot=overTimeRepository.save(overtime);		
		return ot;
	}
	@Override
	public List<OverTime> ListOfStaffOT(int staffid) {		
		return overTimeRepository.findStaffOT(staffid);				
				
	}
	@Override
	public OverTime findById(int otid) {
		return overTimeRepository.findOne(otid);
	}
	@Override
	@Transactional(rollbackFor=OverTimeNotFound.class)
	public OverTime update(OverTime overtime) {
		OverTime otold=overTimeRepository.findOne(overtime.getOtid());
		otold.setNoOfHours(overtime.getNoOfHours());
		otold.setOtdate(overtime.getOtdate());
		overTimeRepository.flush();
		return otold;
	}
	@Override
	@Transactional(rollbackFor=OverTimeNotFound.class)
	public OverTime delete(OverTime overTime) throws OverTimeNotFound {
		OverTime overtimeDeleted=overTimeRepository.findOne(overTime.getOtid());
		if(overtimeDeleted==null){
			throw new OverTimeNotFound();
		}
		overTimeRepository.delete(overtimeDeleted);
		return overtimeDeleted;
	}
	
	
	

}
