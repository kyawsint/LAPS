package nus.iss.laps.repository;

import java.util.List;

import nus.iss.laps.model.Login;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LoginRepository extends JpaRepository<Login,String>{
	@Query("Select s from Login s where s.userId LIKE (:u) and s.password LIKE (:p)")
	public List<Login> verifyUser(@Param("u") String userId,@Param("p") String password);
		

}
