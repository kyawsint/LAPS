package nus.iss.laps.web.validator;

import nus.iss.laps.model.Login;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



@Component
public class LoginValidator implements Validator {
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Login.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Login login = (Login) target;
		ValidationUtils.rejectIfEmpty(errors, "userId", "login.userId.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "login.password.empty");
		//ValidationUtils.rejectIfEmpty(errors, "roleName", "");
		
	
		
	}

}
