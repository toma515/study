package com.itkey.sam.login;

import javax.servlet.http.HttpSession;

public interface LoginService {
	
	/**
	 * 로그인 체크
	 * @param vo , session
	 * @return boolean
	 */
	public boolean loginCheck(LoginVO vo, HttpSession session) throws Exception;
}
