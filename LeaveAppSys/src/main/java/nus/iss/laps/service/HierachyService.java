package nus.iss.laps.service;

import java.util.List;
import nus.iss.laps.exceptions.StaffNotFound;
import nus.iss.laps.model.Hierachy;

public interface HierachyService {
	public Hierachy findStaffDetails(int staffid);

	public String delete(int id) throws StaffNotFound;

	public Hierachy create(Hierachy h);

	public List<Hierachy> findAll();

	public Hierachy findById(Integer id);

	public Hierachy update(Hierachy h) throws StaffNotFound;

}
