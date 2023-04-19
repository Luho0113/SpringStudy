package org.zerock.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.web.vo.ProductVo;

@Controller
public class SampleController2 {
	//만들어진 결과 데이터를 전달하는 경우
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	

	@RequestMapping(value="doD")
	public String doD(Model model) {
		//Model이라는 클래스를 파라미터로 사용(MVC에서 제공하는 클래스)
		//뷰에 원하는 데이터를 전달하는 일종의 컨테이너 역할을 함
		
		//ProductVo 클래스 객체 생성
		ProductVo product = new ProductVo("Sample Product", 10000);
		//객체를 model에 보관함
		model.addAttribute(product); 
		//이름을 따로 지정하지 않으면 자동으로 클래스명의 앞글자를 소문자로 처리한 클래스명을 이름으로 간주
		//뷰에서 product라는 이름으로 객체를 사용할 수 있음
		
		logger.info("doD called...............");
		return "productDetail";
	}
}
