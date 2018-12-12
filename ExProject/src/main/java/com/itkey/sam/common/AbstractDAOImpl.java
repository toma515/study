package com.itkey.sam.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAOImpl implements AbstractDAO {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * DB insert
	 * 
	 * @param queryId
	 * @param params
	 * @return success data count
	 */
	public int insert(String queryId, Object params) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName()
					+ "() QueryId:" + queryId
					+ " Pararm:" + params.toString()
					);
		}
		return sqlSession.insert(queryId, params);
	}

	/**
	 * DB update
	 * 
	 * @param queryId
	 * @param params
	 * @return success data count
	 */
	public int update(String queryId, Object params) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName()
					+ "() QueryId:" + queryId
					+ " Pararm:" + params.toString()
					);
		}
		return sqlSession.update(queryId, params);
	}

	/**
	 * DB delete
	 * 
	 * @param queryId
	 * @param params
	 * @return success data count
	 */
	public int delete(String queryId, Object params) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName()
					+ "() QueryId:" + queryId
					+ " Pararm:" + params.toString()
					);
		}
		return sqlSession.delete(queryId, params);
	}

	/**
	 * DB select one recode without condition
	 * 
	 * @param queryId
	 * @param params
	 * @return success data count
	 */
	public Object select(String queryId) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName()
					+ "() QueryId:" + queryId
					);
		}
		return sqlSession.selectOne(queryId);
	}

	/**
	 * DB select one recode with condition
	 * 
	 * @param queryId
	 * @param params
	 * @return success data count
	 */
	public Object select(String queryId, Object params) throws Exception {
		if (params == null) return select(queryId);

		if (logger.isDebugEnabled()) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName()
					+ "() QueryId:" + queryId
					+ " Pararm:" + params.toString()
					);
		}
		return sqlSession.selectOne(queryId, params);
	}

	/**
	 * DB select all recode without condition
	 * 
	 * @param queryId
	 * @param params
	 * @return success data count
	 */
	public List<?> list(String queryId) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName()
					+ "() QueryId:" + queryId
					);
		}
		return sqlSession.selectList(queryId);
	}

	/**
	 * DB select one recode with condition
	 * 
	 * @param queryId
	 * @param params
	 * @return success data count
	 */
	public List<?> list(String queryId, Object params) throws Exception {
		if (params == null) return list(queryId);

		if (logger.isDebugEnabled()) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName()
					+ "() QueryId:" + queryId
					+ " Pararm:" + params.toString()
					);
		}
		return sqlSession.selectList(queryId, params);
	}
}
