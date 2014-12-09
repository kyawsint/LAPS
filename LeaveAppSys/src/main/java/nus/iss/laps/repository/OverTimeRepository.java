package nus.iss.laps.repository;

import java.util.List;

import nus.iss.laps.model.OverTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OverTimeRepository extends JpaRepository<OverTime, Integer>{
	@Query("select o from OverTime o where o.staffid=(:s)")
	public List<OverTime> findStaffOT(@Param("s") int staffid);

}
