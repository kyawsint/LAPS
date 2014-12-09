package nus.iss.laps.repository;

import nus.iss.laps.model.Claim;
import nus.iss.laps.model.LeaveTypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LeaveTypeRepository extends CrudRepository<LeaveTypes,Long>{
	@Query("select s from LeaveTypes s where s.leaveName='Compensation'")
	public LeaveTypes findLeaveTypes();
}
