package com.itkey.sam.sample;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.itkey.sam.common.AbstractDAOImpl;
import com.itkey.sam.file.FileDTO;

@Repository("sampleDAO")
public class SampleDAOImpl extends AbstractDAOImpl implements SampleDAO {
	private final Logger logger = Logger.getLogger(this.getClass());
	@SuppressWarnings("unchecked")
	public List<SampleDTO> selectSampleList(SampleDTO eDTO) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() eDTO:" + eDTO
					);
		}
		List<SampleDTO> out = (List<SampleDTO>) list("selectSample", eDTO);
		logger.trace("result " + (out==null ? "is null":"count:" + out.size()));
		return out;
	};

	public SampleDTO selectBoardDetail(SampleDTO eDTO) throws Exception{
		logger.error("boardIdx : "+ eDTO.getBoardIdx());
		return (SampleDTO)select("selectSample", eDTO);
	}
	
	

	public int selectSampleCount(SampleDTO eDTO) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() eDTO:" + eDTO
					);
		}

		return (Integer)select("selectSampleCount", eDTO);
	};

	public int insertSample(SampleDTO eDTO) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() eDTO:" + eDTO
					);
		}

		return insert("insertSample", eDTO);
	};
	
	public int insertFile(FileDTO fDTO) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() fDTO:" + fDTO
					);
		}

		return insert("insertFile", fDTO);
	};

	public int updateSample(SampleDTO eDTO) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() eDTO:" + eDTO
					);
		}

		return update("updateSample", eDTO);
	};

	public int updateViewCountUp(SampleDTO eDTO) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() eDTO:" + eDTO
					);
		}
		
		return update("updateViewCountUp", eDTO);
	}
	
	public int deleteSample(String keyId) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() keyId:" + keyId
					);
		}

		return delete("deleteSample", keyId);
	}

	

}