package sample.spring.yse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	//�޼ҵ�
	//����Ÿ�� = ModelAndView
	
	//"/create"��� ��û�� ������ �޼ҵ尡 �����
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create"); 
	}
	
	//test1.jsp�� ������Ѻ���
	@RequestMapping(value="/test1", method =RequestMethod.GET)
	public ModelAndView test1() {
		return new ModelAndView("test/test1");
	}
	
	@RequestMapping(value="/testlogin", method =RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("test/testlogin");
	}
	
	@RequestMapping(value="/testjoin", method =RequestMethod.GET)
	public ModelAndView join() {
		return new ModelAndView("test/testjoin");
	}
	
	@RequestMapping(value="/testboard", method =RequestMethod.GET)
	public ModelAndView board() {
		return new ModelAndView("test/testboard");
	}
}
