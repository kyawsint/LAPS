package nus.iss.laps.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import nus.iss.laps.model.Login;

public interface LoginService {
public List<Login> verifyUserCredentials(String username,String password);

}
