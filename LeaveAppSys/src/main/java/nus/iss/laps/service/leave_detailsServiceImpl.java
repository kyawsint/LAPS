package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import nus.iss.laps.model.Leave_Details;
import nus.iss.laps.repository.leave_detailsRepository;

import org.springframework.stereotype.*;


@Service
public class leave_detailsServiceImpl implements leave_detailsService {
   
	@Resource
	private leave_detailsRepository ldr;
	
	public List<Leave_Details> findAppendingLeave(String leaveStatus){
	   return ldr.findAppendingLeave(leaveStatus);
   }
	
	 public void updateStatus(String leaveStatus,int leaveID){
		 Leave_Details ld =ldr.findOne(leaveID);
		 ld.setLeaveStatus(leaveStatus);
		 ldr.saveAndFlush(ld);
		 //ldr.save(ld);
		 
	 }
	 public Leave_Details findByleaveID(int leaveID){
		 return ldr.findOne(leaveID);
	 }
}
