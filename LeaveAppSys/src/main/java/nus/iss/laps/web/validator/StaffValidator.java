package nus.iss.laps.web.validator;


import nus.iss.laps.model.Staff;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StaffValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Staff.class.isAssignableFrom(clazz);		
	}

	@Override
	public void validate(Object target, Errors errors) {
		Staff staff=(Staff) target;
		ValidationUtils.rejectIfEmpty(errors, "leaveID", "login.userId.empty");
		//ValidationUtils.rejectIfEmpty(errors, "staffID", "login.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "fromDate", "login.userId.empty");
		ValidationUtils.rejectIfEmpty(errors, "noOfDays", "login.password.empty");	
		
	}
}
