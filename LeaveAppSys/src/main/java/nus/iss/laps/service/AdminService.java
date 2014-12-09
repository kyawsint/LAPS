package nus.iss.laps.service;

import java.util.List;

import nus.iss.laps.exceptions.AdminNotFound;
import nus.iss.laps.model.Admin;

public interface AdminService {
	public String delete(int id) throws AdminNotFound;
	public Admin create(Admin s);
	public List<Admin> findAll();
	public Admin findById(Integer id);
	public Admin update(Admin s) throws AdminNotFound;

}
