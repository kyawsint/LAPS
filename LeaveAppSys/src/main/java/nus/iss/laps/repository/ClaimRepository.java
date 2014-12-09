package nus.iss.laps.repository;

import java.sql.Date;
import java.util.List;

import nus.iss.laps.model.Claim;
import nus.iss.laps.model.LeaveTypes;
import nus.iss.laps.model.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClaimRepository extends JpaRepository<Claim,Integer>{
//@Query("select ld from leave_details ld join ld.leavetypes lt where ld.leavetypeid=1")
//public List<LeaveTypes> getLeaveNames();
	
	@Query("select s.staffid from Staff s where s.userid=(:u)")
	public int findStaffid(@Param("u") String userid);
	
	@Query("select s.totalOTHours-s.compOffConsumed from Staff s where s.staffid=(:p)")
	public Double findTotalOTHours(@Param("p") int staffid);
	
	@Query("select c FROM Claim c where c.leaveTypeID=1 and c.staffID=(:s)")
	public List<Claim> findClaimsOfStaff(@Param("s") int staffID);
	
}
