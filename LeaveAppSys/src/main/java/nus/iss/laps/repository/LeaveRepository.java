package nus.iss.laps.repository;

import java.util.List;

import nus.iss.laps.model.Leave;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends CrudRepository<Leave, Long> {
	@Query("select s.staffid from Staff s where s.userid=(:u)")
	public int findStaffid(@Param("u") String userid);
	
	@Query("select l from Leave l where l.staffId=(:n)")
	public List<Leave> findByStaff(@Param("n") long staffId);
}
