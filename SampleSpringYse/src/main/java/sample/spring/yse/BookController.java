package sample.spring.yse;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	//�޼ҵ�
	//����Ÿ�� = ModelAndView
	
	@Autowired
	BookService bookService; // ���񽺸� ȣ���ϱ� ���� ���������� -> ���� ��ü

	// "/create"��� ��û�� ������ �޼ҵ尡 �����
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

	// ���񽺸� �̿��� å�� �Է��ϴ� ��Ʈ�ѷ� �޼ҵ�
	// submit�� ����� �޾ƿ�
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		// bookService�� �޼ҵ� ȣ��
		// map = key�� create.jsp�� �±��� name��, value�� ����ڰ� �Է��� ��
		String bookId = this.bookService.create(map);
		if (bookId == null) {
			mav.setViewName("redirect:/create"); // ���û�ϱ� /create ���
		} else {
			System.out.println("���� ����");
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
	
	//å �� ��Ʈ�ѷ� �޼ҵ� �߰�
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {

		Map<String, Object> detailMap = this.bookService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		
		if (detailMap == null) {
			mav.setViewName("/book/error");
		} else {
			mav.addObject("data", detailMap); // ��� detailMap�� ��(�����ͺ��̽����� ���� ResultSet)�� data �Ӽ��� ��Ƽ� ������
			String bookId = map.get("bookId").toString();
			mav.addObject("bookId", bookId);
			mav.setViewName("/book/detail"); // src/main/webapp/web-inf/views/book/detail.jsp���Ϸ� �����ض�
		}
		return mav;
	}
	
	//å ���� ���
	@RequestMapping(value = "/update", method = RequestMethod.GET) //.jsp���� � ��û�� ������ �Ʒ� �޼ҵ带 �����ض�
	public ModelAndView update(@RequestParam Map<String, Object> map) { //��û�� ������ �Ű������� � Ÿ���� �޴��� ����
		//datail.jsp���� book_id�� ������ ����
		Map<String, Object> detailMap = this.bookService.detail(map); //���� ��ü�� ������, ���� ȣ��
		
		//�� �����ϱ�
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap); //addObject�� ���񽺰�ü�� ���� ����
		mav.setViewName("/book/update"); // update.jsp�� ����
		return mav;
	}
	
	
	// å ���� ��� - ������ �����͸� �Է��ϰ� ���� ��ư�� ������ ����Ǵ� �޼ҵ�
	// update.jsp�� form �±��� post ��� ������ �޼ҵ尡 ����Ǵ� �� 
	// ��û�� ������ ���� ���� ������ ������ �����ϰ�, ������ �����ϸ� ���������� �̵��ϴ� ����� ��� ����
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView(); //��ü ����
		
		//������ �����ߴ��� Ȯ��
		boolean isUpdateSuccess = this.bookService.edit(map); //������ edit�޼ҵ带 ȣ���ϰ� map���� ����
		//true�� ���� ����, false�� ���� ����
		
		//���������� �����Ͱ� ���ŵǸ� Ȯ���� ���� ���������� �̵���
		if (isUpdateSuccess) {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		} else {
			//������ �����ϸ� update�Լ� ȣ���ϰ� �ٽ� ������
			mav = this.update(map);
		}

		return mav;
	}
	
	
//	Map ������ ����
//	{  
//		"bookId": 1,  
//		"title": "���� ����",  
//		"category": "IT",  
//		"price", "10000"  
//	} 
	
	
	//å ���� ��� ��Ʈ�ѷ� �޼ҵ�
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		//������ �����ߴ��� Ȯ��
		boolean isDeleteSuccess = this.bookService.remove(map);
		
		if (isDeleteSuccess) {
			mav.setViewName("redirect:/list"); //������ �����ϸ� ���������� �����Ƿ� ������� �����̷�Ʈ��
		} else {
			//������ �����ϸ� �ٽ� ���������� �̵���
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}

		return mav;
	}
	
	//å ��� ��Ʈ�ѷ� �޼ҵ�
	@RequestMapping(value = "/list")  
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		
		//å ����� �����ͺ��̽����� ������
		// List ���� �ڷ��� ������ Map
		List <Map<String, Object>> list = this.bookService.list(map);
		
		//�����͸� �信 ������ �� �ְ� ��ü�� ������
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list);
		
		if (map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		//list �並 ������
		mav.setViewName("/book/list");
		return mav;
	}

}
