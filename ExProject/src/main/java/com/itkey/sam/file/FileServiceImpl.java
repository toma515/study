package com.itkey.sam.file;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service("fileService")
public class FileServiceImpl implements FileService {
	private final Logger logger = Logger.getLogger(this.getClass());

	@Resource(name="fileDAO")
	FileDAO dao;
	
	@Override
	public FileDTO getFileDetail(FileDTO fDTO) throws Exception {
		
		return dao.selectFileDetail(fDTO);
	}

}
