package com.itkey.sam.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource(name="loginDAO")
	LoginDAO dao;
	
	@Override
	public boolean loginCheck(LoginVO vo, HttpSession session) throws Exception {
		
		LoginVO nVO = dao.selectLoginCheck(vo);
		
		return ( nVO == null) ? false : true ;
	}

}
