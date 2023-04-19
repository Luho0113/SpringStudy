package org.zerock.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.web.vo.ProductVo;

@Controller
public class SampleController2 {
	//������� ��� �����͸� �����ϴ� ���
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	

	@RequestMapping(value="doD")
	public String doD(Model model) {
		//Model�̶�� Ŭ������ �Ķ���ͷ� ���(MVC���� �����ϴ� Ŭ����)
		//�信 ���ϴ� �����͸� �����ϴ� ������ �����̳� ������ ��
		
		//ProductVo Ŭ���� ��ü ����
		ProductVo product = new ProductVo("Sample Product", 10000);
		//��ü�� model�� ������
		model.addAttribute(product); 
		//�̸��� ���� �������� ������ �ڵ����� Ŭ�������� �ձ��ڸ� �ҹ��ڷ� ó���� Ŭ�������� �̸����� ����
		//�信�� product��� �̸����� ��ü�� ����� �� ����
		
		logger.info("doD called...............");
		return "productDetail";
	}
}
