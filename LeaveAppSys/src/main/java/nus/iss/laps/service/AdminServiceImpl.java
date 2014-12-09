package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.laps.exceptions.AdminNotFound;
import nus.iss.laps.model.Admin;
import nus.iss.laps.repository.AdminRepository;
@Service
public class AdminServiceImpl  implements AdminService{


	@Resource
	private AdminRepository adminRepository;
	
	
	@Override
	@Transactional
	public Admin findById(Integer id) {
		return adminRepository.findOne(id);
	}
	
	
	@Override
	@Transactional
	public Admin update(Admin s) throws AdminNotFound {
		Admin updated = adminRepository.findOne(s.getTypeid());
		
		if (updated== null)
			throw new AdminNotFound();
		updated.setTypeid(s.getTypeid());
		updated.setLeaveName(s.getLeaveName());
		
		adminRepository.flush();
		return updated;
	}
	
	@Override
	@Transactional
	public String delete(int id) throws AdminNotFound {

		Admin obj = adminRepository.findOne(id);
		
		String deleteAdminNAme= obj.getLeaveName();
		
		/*if (deleteAdimin == null){
			throw new AdiminNotFound();}
		*/
		adminRepository.delete(obj);
		
		return deleteAdminNAme;
	}

	@Override
	@Transactional
	public Admin create(Admin s) {
		Admin createdLeave = s;
		return adminRepository.save(createdLeave);
	}

	@Override
	@Transactional
	public List<Admin> findAll() {
		
		return adminRepository.findAll();
		
	}
	
}
