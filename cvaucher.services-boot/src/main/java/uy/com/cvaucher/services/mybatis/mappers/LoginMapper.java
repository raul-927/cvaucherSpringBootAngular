package uy.com.cvaucher.services.mybatis.mappers;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import uy.com.cvaucher.services.domain.Login;
import uy.com.cvaucher.services.mybatis.sql.SqlLoginProvider;

public interface LoginMapper {
	
	
	@SelectProvider(type =SqlLoginProvider.class, method ="showLoginUser")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.LoginMapper.LoginResult")
	Login showLoginUser(String domUserNic);

}
