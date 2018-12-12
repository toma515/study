package com.itkey.sam.file;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FileController {
	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired FileService fileService;
	
	/*파일다운로드*/
	@RequestMapping(value="/downloadFile.do")
	public void downloadFile(@ModelAttribute FileDTO fDTO, HttpServletResponse response)throws Exception{
		fDTO = fileService.getFileDetail(fDTO);
		String path = fDTO.getFilePath().toString()+fDTO.getFileChangedName().toString();
		byte fileByte[] = FileUtils.readFileToByteArray(new File(path));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" 
		+ URLEncoder.encode(fDTO.getFileOriginalName().toString(),"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
