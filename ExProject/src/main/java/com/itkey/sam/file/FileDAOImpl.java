package com.itkey.sam.file;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.itkey.sam.common.AbstractDAOImpl;

@Repository("fileDAO")
public class FileDAOImpl extends AbstractDAOImpl implements FileDAO {
	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public FileDTO selectFileDetail(FileDTO fDTO) throws Exception {
		logger.error("fileIdx : "+ fDTO.getFileIdx());
		return (FileDTO)select("selectFile", fDTO);
	};

}
