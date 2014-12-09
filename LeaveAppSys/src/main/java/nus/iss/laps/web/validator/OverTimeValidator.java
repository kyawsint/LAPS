package nus.iss.laps.web.validator;


import nus.iss.laps.model.OverTime;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class OverTimeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return OverTime.class.isAssignableFrom(clazz);		
	}

	@Override
	public void validate(Object target, Errors errors) {
		OverTime overTime=(OverTime) target;
		ValidationUtils.rejectIfEmpty(errors, "otid", "otime.otid.empty");
		ValidationUtils.rejectIfEmpty(errors, "otdate", "otime.otdate.empty");
		ValidationUtils.rejectIfEmpty(errors, "noOfHours", "otime.noOfHours.empty");
		ValidationUtils.rejectIfEmpty(errors, "staffid", "otime.staffid.empty");	
		
	}

}
