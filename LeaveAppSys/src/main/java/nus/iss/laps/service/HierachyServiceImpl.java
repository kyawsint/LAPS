package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.laps.repository.*;
import nus.iss.laps.exceptions.*;
import nus.iss.laps.model.*;

@Service
public class HierachyServiceImpl implements HierachyService {

	@Resource
	private HierachyRepository hierachyRepository;

	@Override
	public Hierachy findStaffDetails(int staffid) {
		return hierachyRepository.findOne(staffid);
	}

	@Override
	@Transactional
	public Hierachy findById(Integer staffid) {
		return hierachyRepository.findOne(staffid);
	}

	@Override
	@Transactional
	public Hierachy update(Hierachy h) throws StaffNotFound {
		Hierachy updated = hierachyRepository.findOne(h.getStaffid());

		if (updated == null)
			throw new StaffNotFound();
		updated.setStaff_name(h.getStaff_name());
		updated.setReportsTo(h.getReportsTo());

		hierachyRepository.flush();
		return updated;
	}

	@Override
	@Transactional
	public String delete(int staffid) throws StaffNotFound {

		Hierachy obj = hierachyRepository.findOne(staffid);

		String deleteStaffNAme = obj.getStaff_name();

		/*
		 * if (deleteAdimin == null){ throw new AdiminNotFound();}
		 */
		hierachyRepository.delete(obj);

		return deleteStaffNAme;
	}

	@Override
	@Transactional
	public Hierachy create(Hierachy h) {
		Hierachy createdLeave = h;
		return hierachyRepository.save(createdLeave);
	}

	@Override
	@Transactional
	public List<Hierachy> findAll() {

		return hierachyRepository.findAll();

	}
}
