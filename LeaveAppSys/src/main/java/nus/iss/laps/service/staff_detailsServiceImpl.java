package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import nus.iss.laps.model.staff_details;
import nus.iss.laps.repository.staff_detailsRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class staff_detailsServiceImpl implements staff_detailsService{
     
	@Resource
	private staff_detailsRepository sdr;
	
	  @Override
      @Transactional
      public List<staff_details> findAll(){
           
    	  return sdr.findAll();
      }
      
      @Override
      @Transactional
      public staff_details findByStaffid(int staffid){
    	  return sdr.findOne(staffid);
      }
      @Override
      @Transactional
      public void update(staff_details s){
    	  sdr.saveAndFlush(s);
      }
      
}
