package nus.iss.laps.repository;


import nus.iss.laps.model.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StaffRepository  extends JpaRepository<Staff,Integer>{
	//@Query("select s.totalOTHours from Staff s where ")
	@Query("select s.staffid from Staff s where s.userid=(:u)")
	public int findStaffid(@Param("u") String userid);
	
	
}
