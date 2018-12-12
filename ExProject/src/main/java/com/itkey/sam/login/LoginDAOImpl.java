package com.itkey.sam.login;

import org.springframework.stereotype.Repository;

import com.itkey.sam.common.AbstractDAOImpl;



@Repository("loginDAO")
public class LoginDAOImpl extends AbstractDAOImpl implements LoginDAO {

	@Override
	public LoginVO selectLoginCheck(LoginVO vo) throws Exception {
		
		return (LoginVO)select("loginCheck", vo);
	}

}
