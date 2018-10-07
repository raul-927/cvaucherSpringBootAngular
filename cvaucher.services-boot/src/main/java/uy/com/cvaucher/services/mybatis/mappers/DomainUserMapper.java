package uy.com.cvaucher.services.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import uy.com.cvaucher.services.domain.DomainUser;
import uy.com.cvaucher.services.mybatis.sql.SqlDomainProvider;

public interface DomainUserMapper 
{
	@SelectProvider(type=SqlDomainProvider.class, method="findAllDomainUsers")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.DomainUserMapper.DomainUserResult")
	List<DomainUser> findAllDomainUsers();
	
	@SelectProvider(type=SqlDomainProvider.class, method="findDomainUserById")
	//@Select("SELECT * FROM domain_user WHERE dom_usr_id = #{domUsrId}")
	@ResultMap("uy.com.cvaucher.services.mybatis.mappers.DomainUserMapper.DomainUserResult")
	DomainUser findDomainUserById(int domUsrId);
	
	@SelectProvider(type=SqlDomainProvider.class, method="insertDomainUser")
//	@Insert("INSERT INTO domain_user " +
//			"(dom_usr_nom, dom_usr_ap, dom_usr_nic, dom_usr_pass, dom_usr_enabled) " +
//			"VALUES " +
//			"(#{domUsrNom}, #{domUsrAp}, #{domUsrNic}, #{domUsrPass}, #{domUsrEnabled})")
	void insertDomainUser(DomainUser domainUser);
	
	@SelectProvider(type=SqlDomainProvider.class, method="updateDomainUser")
//	@Update("UPDATE domain_user SET " +
//			"dom_user_nom = #{domUsrNom}, dom_usr_ap = #{domUsrAp}, dom_usr_nic = #{domUsrNic} " +
//			"WHERE dom_usr_id = #{domainUser.domUsrId}")
	void updateDomainUser(DomainUser domainUser);
	
	@SelectProvider(type=SqlDomainProvider.class, method="deleteDomainUser")
	//@Delete("DELETE FROM domain_user WHERE dom_usr_id = #{domUsrId}")
	void deleteDomainUser(int domUsrId);
}
