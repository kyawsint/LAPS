package nus.iss.laps.web.validator;

import java.sql.Date;

import org.springframework.validation.Validator;

import nus.iss.laps.model.Claim;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class ClaimValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return Claim.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Claim claim = (Claim) target;
		ValidationUtils.rejectIfEmpty(errors, "leaveID", "claim.leaveID.empty");
		//ValidationUtils.rejectIfEmpty(errors, "staffID", "claim.staffID.empty");
		
		ValidationUtils.rejectIfEmpty(errors, "noOfDays", "claim.noOfDays.empty");	
		ValidationUtils.rejectIfEmpty(errors, "fromDate", "claim.fromDate.empty");	
	}
}
