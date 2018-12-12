package com.itkey.sam.login;

public interface LoginDAO {
	/**
	 * 로그인 체크
	 * @param vo 
	 * @return boolean
	 */
	public LoginVO selectLoginCheck(LoginVO vo) throws Exception;
}
