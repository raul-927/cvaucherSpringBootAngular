package uy.com.cvaucher.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.com.cvaucher.services.domain.Login;
import uy.com.cvaucher.services.mybatis.mappers.LoginMapper;
import uy.com.cvaucher.services.services.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	@Override
	public Login showLoginUser(String domUserNic) {
		
		return loginMapper.showLoginUser(domUserNic);
		
	}

}
