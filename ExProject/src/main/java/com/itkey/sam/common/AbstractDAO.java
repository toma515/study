package com.itkey.sam.common;

import java.util.List;

public interface AbstractDAO {

	
	/**
	 * DB insert
	 * @param queryId
	 * @param params
	 * @return success data count
	 */
	public int insert(String queryId, Object params) throws Exception;

	/**
	 * DB update
	 * @param queryId
	 * @param params
	 * @throws Exception 
	 * @return success data count
	 */
	public int update(String queryId, Object params) throws Exception;

	/**
	 * DB delete
	 * @param queryId
	 * @param params
	 * @throws Exception 
	 * @return success data count
	 */
	public int delete(String queryId, Object params) throws Exception;

	/**
	 * DB select one recode without condition
	 * @param queryId
	 * @param params
	 * @throws Exception 
	 * @return success data count
	 */
	public Object select(String queryId) throws Exception;

	/**
	 * DB select one recode with condition
	 * @param queryId
	 * @param params
	 * @return success data count
	 * @throws Exception 
	 */
	public Object select(String queryId, Object params) throws Exception;

	/**
	 * DB select all recode without condition
	 * @param queryId
	 * @param params
	 * @throws Exception 
	 * @return success data count
	 */
	public List<?> list(String queryId) throws Exception;

	/**
	 * DB select one recode with condition
	 * @param queryId
	 * @param params
	 * @throws Exception 
	 * @return success data count
	 */
	public List<?> list(String queryId, Object params) throws Exception;

}
