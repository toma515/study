package com.itkey.sam.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger; // 濡쒓렇瑜� 李띻린�쐞�븳 �겢�옒�뒪 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView; // model怨� 酉곕�� 諛섑솚�븯湲� �쐞�븳 �겢�옒�뒪



@Controller
public class LoginController {
	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired LoginService loginService;
	
	
	/*濡쒓렇�씤 �럹�씠吏� �뿴湲�*/
	@RequestMapping(value = "/login.do")
	public ModelAndView login(@RequestParam Map<String, Object> requestParam) throws Exception {
		logger.info("Welcome to Seedit");
		ModelAndView mv = new ModelAndView("login/login");
		return mv;
	}
	
	/*濡쒓렇�씤泥댄겕*/
	@RequestMapping(value = "/loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute LoginVO vo, HttpServletRequest request) throws Exception {
//		boolean result = loginService.loginCheck(vo, session);
		ModelAndView mv = new ModelAndView("redirect:/sample.do");
		
		if(vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", vo);
		}
//		if(result) {
//			mv.setViewName("redirect:/sample.do");
//		}else {
//			mv.setViewName("redirect:/login.do" );
//		}
		
		mv.addObject("data", vo);
		return mv;
	}
	
	@RequestMapping(value = "/testCheck.do")
	@ResponseBody 
	public Map<String, Object> testCheck(@RequestBody LoginVO vo) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("msg", "�꽦怨�");
		result.put("nVo", vo);
		//result.put("nextPage", "sample.do");
		return result;
	}
	
	
	
	
}
