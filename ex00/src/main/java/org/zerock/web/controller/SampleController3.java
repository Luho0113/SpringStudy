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
	//�����̷�Ʈ
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	

	@RequestMapping(value="doE")
	public String doE(RedirectAttributes rttr) {
		
		logger.info("doE called...............");
		
		//msg��� �̸��� �����͸� �߰�
		//addFlashAttribute = �ӽ� �����͸� ��������
		rttr.addFlashAttribute("msg", "This is the Message with redirected!");
		
		//Ŭ���̾�Ʈ���� /doF �� ��û�ϰ� ��
		return "redirect:/doF";
	}
	
	@RequestMapping(value="doF")
	public void doF(@ModelAttribute String msg) {
		
		logger.info("doF called..............." + msg);
		
	}
}
