package org.zerock.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.web.vo.ProductVo;

@Controller
public class SampleController3 {
	//리다이렉트
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	

	@RequestMapping(value="doE")
	public String doE(RedirectAttributes rttr) {
		
		logger.info("doE called...............");
		
		//msg라는 이름의 데이터를 추가
		//addFlashAttribute = 임시 데이터를 전달해줌
		rttr.addFlashAttribute("msg", "This is the Message with redirected!");
		
		//클라이언트에서 /doF 를 요청하게 됨
		return "redirect:/doF";
	}
	
	@RequestMapping(value="doF")
	public void doF(@ModelAttribute String msg) {
		
		logger.info("doF called..............." + msg);
		
	}
}
