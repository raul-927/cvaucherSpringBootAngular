package uy.com.cvaucher.services.mybatis.sql;


import org.apache.ibatis.jdbc.SQL;

import uy.com.cvaucher.services.domain.DomainUser;

public class SqlDomainProvider {
	
	
	public String findAllDomainUsers() {
		
		
		return new SQL() {{
			SELECT("dom_usr_id, dom_usr_nom, dom_usr_ap, dom_usr_nic, dom_usr_pass, dom_usr_enabled");
			FROM("domain_user");			
		}}.toString();
	}
	
	public String findDomainUserById(final int domUsrId) {
		return new SQL() {{
			SELECT("dom_usr_id, dom_usr_nom, dom_usr_ap, dom_usr_nic, dom_usr_pass, dom_usr_enabled");
			FROM("domain_user");
			WHERE("dom_usr_id = "+domUsrId);
		}}.toString();
		
	}
	
	public String insertDomainUser(final DomainUser domainUser) {
		return new SQL() {{
			INSERT_INTO("domain_user");
			if(domainUser.getDomUsrNom()!=null) {
				VALUES("dom_usr_nom",domainUser.getDomUsrNom());
			}
			if(domainUser.getDomUsrAp()!=null) {
				VALUES("dom_usr_ap",domainUser.getDomUsrAp());
			}
			if(domainUser.getDomUsrNic()!=null) {
				VALUES("dom_usr_nic",domainUser.getDomUsrNic());
			}
			if(domainUser.getDomUsrPass()!=null) {
				VALUES("dom_usr_pass",domainUser.getDomUsrPass());
			}
			VALUES("dom_usr_enabled",String.valueOf(domainUser.getDomUsrEnabled()));
		}}.toString();
	}
	
	public String updateDomainUser(final DomainUser domainUser) {
		return new SQL() {{
			if(domainUser.getDomUsrId() !=0) {
				UPDATE("domain_user");
				if(domainUser.getDomUsrAp() != null) {
					SET("dom_usr_ap   = "+domainUser.getDomUsrAp());
				}
				if(domainUser.getDomUsrNom() != null) {
					SET("dom_usr_nom  = "+domainUser.getDomUsrNom());
				}
				if(domainUser.getDomUsrNic() !=null) {
					SET("dom_usr_nic  = "+domainUser.getDomUsrNic());
				}
				if(domainUser.getDomUsrPass() != null) {
					SET("dom_usr_pass = "+domainUser.getDomUsrPass());
				}
				WHERE("dom_usr_id = "+domainUser.getDomUsrId());
			}
		}}.toString();
	}
	
	public String deleteDomainUser(final int domUsrId) {
		return new SQL() {{
			if(domUsrId != 0) {
				DELETE_FROM("domain_user");
				WHERE("dom_usr_id = "+domUsrId);
			}
		}}.toString();
	}

}
