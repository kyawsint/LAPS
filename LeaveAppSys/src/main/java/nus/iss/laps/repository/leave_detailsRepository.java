package nus.iss.laps.repository;

import java.util.List;

import nus.iss.laps.model.Leave_Details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface leave_detailsRepository extends JpaRepository<Leave_Details,Integer>{
	@Query("select l from Leave_Details l where leaveStatus= :u")
	public List<Leave_Details> findAppendingLeave(@Param("u") String leaveStatus);
	
//	@Query("update leave_details l set l.leaveStatus = :u where l.leaveID = :o ")
//	public void updateStatus(@Param("u")String leaveStatus,@Param("o") int leaveID);
}
