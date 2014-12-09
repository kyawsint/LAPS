package nus.iss.laps.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.laps.model.Login;
import nus.iss.laps.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	@Resource
	private LoginRepository loginRepository;

	@Override
	@Transactional
	public List<Login> verifyUserCredentials(String username, String password) {

		return loginRepository.verifyUser(username, password);
	}
	

}
