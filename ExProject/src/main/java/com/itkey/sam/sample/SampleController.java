package com.itkey.sam.sample;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger; // 로그를 찍기위한 클래스 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView; // model과 뷰를 반환하기 위한 클래스

import com.itkey.sam.file.FileDTO;
import com.itkey.sam.file.FileService;
import com.itkey.sam.setting.PageSetting;

@Controller
public class SampleController {
	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired SampleService sampleService;
	@Autowired FileService fileService;
	/**
	 * Sample Controller for '' db roup
	 */
	
	/*게시판 목록페이지 열기*/
	@RequestMapping(value = "/sample.do")
	public ModelAndView sample(@RequestParam Map<String, Object> requestParam) throws Exception {
		logger.error("Welcome to Seedit");
		ModelAndView mv = new ModelAndView("board/sampleBoard");
		SampleDTO eDTO = new SampleDTO();

		int totalCount = sampleService.getSampleCount(eDTO);
		int curPage = 1; 
		if(requestParam.get("page") != null) {
			curPage =  Integer.parseInt(requestParam.get("page").toString());
		}

		eDTO.setOffset((curPage-1)*10);
		eDTO.setRow(10);
		PageSetting ps = new PageSetting(curPage, totalCount);
		
		
		List<SampleDTO> oList = sampleService.getSampleList(eDTO);
		mv.addObject("list", oList);
		mv.addObject("paging", ps);
		return mv;
	}
	
	/*게시판 상세페이지 열기 조회수 1 증가*/
	@RequestMapping(value = "/openBoardDetail.do")
	public ModelAndView openSampleDetail(@RequestParam Map<String, Object> requestParam) throws Exception {
		logger.error("boardIdx : "+ requestParam.get("boardIdx").toString());
		ModelAndView mv = new ModelAndView("board/boardDetail");
		SampleDTO eDTO = new  SampleDTO();
		List<FileDTO> list = new ArrayList<FileDTO>();
		
		eDTO.setBoardIdx(requestParam.get("boardIdx").toString());
		eDTO = sampleService.getBoardDetail(eDTO);
		if(eDTO.getFileIdx() != null) {
			String arrIdx[] = eDTO.getFileIdx().split(",");
			for(int i=0 ; i < arrIdx.length ; i++ ) {
				FileDTO fDTO = new FileDTO();
				fDTO.setFileIdx(arrIdx[i]);
				fDTO = fileService.getFileDetail(fDTO);
				list.add(fDTO);
			}
			
		}
		logger.error("BoardWriter : "+ eDTO.getBoardWriter().toString() );
		mv.addObject("result", eDTO);
		mv.addObject("list", list);
		
		return mv;
	}
	
	/*게시글 작성페이지 열기*/
	@RequestMapping(value = "/openBoardWrite.do")
	public ModelAndView openSampleWrite(@RequestParam Map<String, Object> requestParam) throws Exception {
		ModelAndView mv = new ModelAndView("board/boardWrite");
		return mv;
	}
	
	/*게시글 수정페이지 열기*/
	@RequestMapping(value = "/openBoardUpdate.do")
	public ModelAndView openSampleUpdate(@RequestParam Map<String, Object> requestParam) throws Exception {
		ModelAndView mv = new ModelAndView("board/boardUpdate");
		SampleDTO eDTO = new  SampleDTO();
		List<FileDTO> list = new ArrayList<FileDTO>();
		
		eDTO.setBoardIdx(requestParam.get("boardIdx").toString());
		eDTO = sampleService.getBoardDetail(eDTO);
		if(eDTO.getFileIdx() != null) {
			String arrIdx[] = eDTO.getFileIdx().split(",");
			for(int i=0 ; i < arrIdx.length ; i++ ) {
				FileDTO fDTO = new FileDTO();
				fDTO.setFileIdx(arrIdx[i]);
				fDTO = fileService.getFileDetail(fDTO);
				list.add(fDTO);
			}
			
		}
		mv.addObject("result", eDTO);
		mv.addObject("list", list);
		
		return mv;
	}
	
	/*게시글 작성 db에 등록 후 게시판목록페이지 열기*/
	@RequestMapping(value = "/insertBoard.do")
	public ModelAndView insertBoard(@RequestParam Map<String, Object> requestParam, HttpServletRequest request) throws Exception {
		logger.error(requestParam);
		ModelAndView mv = new ModelAndView("redirect:/sample.do");
		SampleDTO eDTO = new SampleDTO();
		eDTO.setBoardTitle(requestParam.get("boardTitle").toString());
		eDTO.setBoardWriter(requestParam.get("boardWriter").toString());
		eDTO.setBoardContents(requestParam.get("boardContents").toString());
		eDTO.setBoardViewCount("0");
		logger.error(eDTO.getBoardContents().toString());
		sampleService.addSample(eDTO, request);
		
		return mv;
	}
	
	/*수정한 게시글 db에 등록 후 게시판목록페이지 열기*/
	@RequestMapping(value = "/updateBoard.do")
	public ModelAndView updateBoard(@RequestParam Map<String, Object> requestParam, HttpServletRequest request) throws Exception {
		logger.error(requestParam);
		ModelAndView mv = new ModelAndView("redirect:/openBoardDetail.do");
		
		sampleService.chgSample(requestParam, request);
		
		mv.addObject("boardIdx", requestParam.get("boardIdx").toString());
		return mv;
	}
	
	/*수정한 게시글 db에 등록 후 게시판목록페이지 열기*/
	@RequestMapping(value = "/deleteBoard.do")
	public ModelAndView deleteBoard(@RequestParam Map<String, Object> requestParam) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/sample.do");
		sampleService.delSample(requestParam.get("boardIdx").toString());
		
		return mv;
	}
	
	
	
	@RequestMapping(value = "/home.do")
	public ModelAndView home(@RequestParam Map<String, Object> requestParam) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/login.do");
//		SampleDTO eDTO = new SampleDTO();
//		int totalCount = sampleService.getSampleCount(eDTO);
//		logger.info("현제페이지 : " + requestParam.get("page") + "쪽 ");
//		int curPage =  Integer.parseInt(requestParam.get("page").toString());
//		logger.info(" 총게시글 : " + totalCount + "개 , 현제페이지 : " 
//				+ curPage + "쪽 ");
//		
//		eDTO.setOffset((curPage-1)*10);
//		eDTO.setRow(10);
//		
//		mv.addObject("count", sampleService.getSampleCount(eDTO));
//		mv.addObject("paging", eDTO);
//		mv.addObject("curPage", curPage);
//		
		return mv;
	}
	
	

}
