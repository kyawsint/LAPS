package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import nus.iss.laps.exceptions.StaffNotFound;
import nus.iss.laps.model.Staff;
import nus.iss.laps.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService{

	@Resource
	private StaffRepository staffRepository;
	@Override
	public int findStaffDetails(String userid) {
		return staffRepository.findStaffid(userid);
	}
	@Override
	@Transactional(rollbackFor=StaffNotFound.class)
	public Staff update(Staff staffdet) {
		
		Staff staffotBefore=staffRepository.findOne(staffdet.getStaffid());
		double totalOTBefore=staffotBefore.getTotalOTHours();

		totalOTBefore=totalOTBefore+staffdet.getTotalOTHours();
		System.out.println("totalOTBefore "+totalOTBefore);
		staffotBefore.setTotalOTHours(totalOTBefore);
		 staffRepository.flush();
		 return staffotBefore;
	}
	
	
	@Override
	public Staff findById(int staffid) {

		return staffRepository.findOne(staffid);
	}
	@Override
	@Transactional(rollbackFor=StaffNotFound.class)
	public Staff updateCompOff(double noOfDays,int staffid) {
		Staff staffCompOff=staffRepository.findOne(staffid);
		double oldCompOff=staffCompOff.getCompOffConsumed();
		double newCompOff=oldCompOff-noOfDays;
		staffCompOff.setCompOffConsumed(newCompOff);
		staffRepository.flush();
		return staffCompOff;
	}

	@Override
	@Transactional
	public List<Staff> findAll() {
		return staffRepository.findAll();
	}
	
	@Override
	@Transactional(rollbackFor=StaffNotFound.class)
	public Staff  delete(int staffid) throws StaffNotFound {
		Staff  deletedStaff = staffRepository.findOne(staffid);
		
		if (deletedStaff == null)
			throw new StaffNotFound();
		
		staffRepository.delete(deletedStaff);
		return deletedStaff;
	}
	
	@Override
	@Transactional
	public Staff create(Staff s) {
		Staff createdStaff = s;
		return staffRepository.save(createdStaff);
	}
	
	@Override
	@Transactional(rollbackFor=StaffNotFound.class)
	public Staff  updateAll(Staff  s) throws StaffNotFound {
		Staff  updatedStaff = staffRepository.findOne(s.getStaffid());
		
		if (updatedStaff== null)
			throw new StaffNotFound();
		updatedStaff.setStaffid(s.getStaffid());
		updatedStaff.setStaff_name(s.getStaff_name());
		updatedStaff.setUserid(s.getUserid());
		updatedStaff.setReportsTo(s.getReportsTo());
		updatedStaff.setDob(s.getDob());
		updatedStaff.setAddress(s.getAddress());
		updatedStaff.setContactno(s.getContactno());
		updatedStaff.setEmailid(s.getEmailid());
		staffRepository.flush();
		return updatedStaff;
	}
	@Override
	@Transactional(rollbackFor=StaffNotFound.class)
	public Staff updateTotalOT(double oldOT, double newOT,Staff staff_det) throws StaffNotFound{
		Staff updateStaffOT=staffRepository.findOne(staff_det.getStaffid());
		double newOTHours=updateStaffOT.getTotalOTHours()-oldOT;
		newOTHours=newOTHours+newOT;
		updateStaffOT.setTotalOTHours(newOTHours);
		staffRepository.flush();
		return updateStaffOT;
	}
//	 @Override
//     @Transactional
//     public Staff findByStaffid(int staffid){
//   	  return staffRepository.findOne(staffid);
//     }
	
}
