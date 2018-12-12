package com.itkey.sam.sample;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.itkey.sam.file.FileDAO;
import com.itkey.sam.file.FileDTO;
import com.itkey.sam.util.FileUtils;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	private final Logger logger = Logger.getLogger(this.getClass());

	@Resource(name="sampleDAO")
	SampleDAO dao;
	
	@Resource(name="fileDAO")
	FileDAO fDao;
	
	@Resource(name="fileUtils")
	FileUtils fileUtils;

	public List<SampleDTO> getSampleList(SampleDTO eDTO) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() eDTO:" + eDTO
					);
		}
		
		return dao.selectSampleList(eDTO);
	}
	
	public SampleDTO getBoardDetail(SampleDTO eDTO) throws Exception{
		logger.error("boardIdx : "+ eDTO.getBoardIdx());
		
		dao.updateViewCountUp(eDTO);
		
		return dao.selectBoardDetail(eDTO);
	}
	
	
	
	public int getSampleCount(SampleDTO eDTO) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() eDTO:" + eDTO
					);
		}

		return dao.selectSampleCount(eDTO);
	}
	
	public int addSample(SampleDTO eDTO, HttpServletRequest request) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() eDTO:" + eDTO
					);
		}
		
		/*업로드 하나만 할때 사용했음*/
//		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//		MultipartFile multipartFile = null;
//		String filePath = "C:\\dev\\file\\";
//		Map<String, Object> map= null;
//		String str_fileIdx = null;
//		while (iterator.hasNext()) {
//			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
//			if(multipartFile.isEmpty() == false) {
//				logger.debug("------------------- file start -------------------");
//				logger.debug("name : " + multipartFile.getName() );
//				logger.debug("filename : " + multipartFile.getOriginalFilename() );
//				logger.debug("size : " + multipartFile.getSize() );
//				logger.debug("-------------------  file end  -------------------");
//				String originalFileName = multipartFile.getOriginalFilename();
//                String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
//                String changedFileName = CommonUtils.getRandomString() + originalFileExtension;
//				File file = new File(filePath+ changedFileName);
//				multipartFile.transferTo(file);
//				
//				map = new HashMap<String, Object>();
//				map.put("fileOriginalName",originalFileName);
//				map.put("filePath", filePath);
//				map.put("fileChangedName", changedFileName);
//				dao.insertFile(map);
//				str_fileIdx = (String)map.get("IDX");
//			}
//		}
		String sample_fileIdx = "";
		
		List<FileDTO> list = fileUtils.parseInsertFileInfo(request);
		for (int i=0 ; i<list.size() ; i++) {
			dao.insertFile(list.get(i));
			String str_fileIdx = list.get(i).getfIDX();
			sample_fileIdx += str_fileIdx;
			if(i<list.size()-1) {
				sample_fileIdx += ",";
			}
		}
		eDTO.setFileIdx(sample_fileIdx);
		return dao.insertSample(eDTO);
	}

	public int chgSample(Map<String, Object> map, HttpServletRequest request) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() map:" + map
					);
		}
		
		String sample_fileIdx = "";
		
		List<FileDTO> list = fileUtils.parseUpdateFileInfo(map, request);
		for (int i=0 ; i<list.size() ; i++) {
			String str = list.get(i).getHandleFile().toString();
			
			/*switch (str) { jaja 7버젼만 string value 로 지정 가능 
			case "N":// 기존파일
				sample_fileIdx += list.get(i).getFileIdx();
				break;
				
			case "C"://파일생성
				dao.insertFile(list.get(i));
				sample_fileIdx += list.get(i).getfIDX();
				break;
				
			case "D"://파일삭제
				
				break;	
				
			default:
				break;
			}*/
			
			if(str.equals("N")) {
				sample_fileIdx += list.get(i).getFileIdx();
			}else if(str.equals("C")) {
				/*dao.insertFile(list.get(i));*/
				sample_fileIdx += list.get(i).getfIDX();
			}else if(str.equals("D")) {
				
			}
			
			if(i<list.size()-1) {
				sample_fileIdx += ",";
			}
		}
		
		
		SampleDTO eDTO = new SampleDTO();
		eDTO.setBoardIdx(map.get("boardIdx").toString());
		eDTO.setBoardTitle(map.get("boardTitle").toString());
		eDTO.setBoardContents(map.get("boardContents").toString());
		eDTO.setFileIdx(sample_fileIdx);

		return /*dao.updateSample(eDTO)*/1;
	}

	public int delSample(String keyId) throws Exception {
		if (logger.isTraceEnabled()) {
			logger.trace(new Exception().getStackTrace()[0].getMethodName()
					+ "() keyId:" + keyId
					);
		}

		return dao.deleteSample(keyId);
	}
	
	

}