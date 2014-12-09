package nus.iss.laps.repository;

import java.util.List;

import nus.iss.laps.model.Leave_Details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeaveHistoryRepository extends JpaRepository<Leave_Details, Integer> {
	//@Query("Select l from Leave_Details l where l.staffID LIKE :staffID")

	public List<Leave_Details> findByStaffID(@Param("staffID")int staffID);
	
	//public List<Leave_Details> findByStaffID(@Param("staffID")int staffID);
	@Query("select l from Leave_Details l where l.leaveTypeID = :u")
	public List<Leave_Details> findByLeaveTypeID(@Param("u") int leaveTypeID);
}
