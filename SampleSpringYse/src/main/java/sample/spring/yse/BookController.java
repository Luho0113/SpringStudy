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

	//메소드
	//리턴타입 = ModelAndView
	
	@Autowired
	BookService bookService; // 서비스를 호출하기 위해 의존성주입 -> 서비스 객체

	// "/create"라는 요청이 들어오면 메소드가 실행됨
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}

	// 서비스를 이용해 책을 입력하는 컨트롤러 메소드
	// submit의 결과를 받아옴
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		// bookService의 메소드 호출
		// map = key는 create.jsp의 태그의 name명, value는 사용자가 입력한 값
		String bookId = this.bookService.create(map);
		if (bookId == null) {
			mav.setViewName("redirect:/create"); // 재요청하기 /create 라고
		} else {
			System.out.println("삽입 성공");
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
	
	//책 상세 컨트롤러 메소드 추가
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {

		Map<String, Object> detailMap = this.bookService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		
		if (detailMap == null) {
			mav.setViewName("/book/error");
		} else {
			mav.addObject("data", detailMap); // 뷰로 detailMap의 값(데이터베이스에서 받은 ResultSet)을 data 속성에 담아서 보내라
			String bookId = map.get("bookId").toString();
			mav.addObject("bookId", bookId);
			mav.setViewName("/book/detail"); // src/main/webapp/web-inf/views/book/detail.jsp파일로 응답해라
		}
		return mav;
	}
	
	//책 수정 기능
	@RequestMapping(value = "/update", method = RequestMethod.GET) //.jsp에서 어떤 요청이 들어오면 아래 메소드를 수행해라
	public ModelAndView update(@RequestParam Map<String, Object> map) { //요청이 들어오면 매개변수로 어떤 타입을 받는지 정의
		//datail.jsp에서 book_id를 가지고 들어옴
		Map<String, Object> detailMap = this.bookService.detail(map); //서비스 객체를 전달함, 서비스 호출
		
		//뷰 생성하기
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap); //addObject로 서비스객체를 전달 받음
		mav.setViewName("/book/update"); // update.jsp로 응답
		return mav;
	}
	
	
	// 책 수정 기능 - 수정할 데이터를 입력하고 저장 버튼을 누르면 수행되는 메소드
	// update.jsp의 form 태그의 post 방식 때문에 메소드가 수행되는 것 
	// 요청을 받으면 서비를 통해 수정된 내용을 전달하고, 수정이 성공하면 상세페이지로 이동하는 기능을 담고 있음
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		
		ModelAndView mav = new ModelAndView(); //객체 생성
		
		//수정이 성공했는지 확인
		boolean isUpdateSuccess = this.bookService.edit(map); //서비스의 edit메소드를 호출하고 map으로 담음
		//true면 갱신 성공, false면 갱신 실패
		
		//정상적으로 데이터가 갱신되면 확인을 위해 상세페이지로 이동함
		if (isUpdateSuccess) {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		} else {
			//갱신이 실패하면 update함수 호출하고 다시 수행함
			mav = this.update(map);
		}

		return mav;
	}
	
	
//	Map 데이터 예시
//	{  
//		"bookId": 1,  
//		"title": "제목 수정",  
//		"category": "IT",  
//		"price", "10000"  
//	} 
	
	
	//책 삭제 기능 컨트롤러 메소드
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		//삭제가 성공했는지 확인
		boolean isDeleteSuccess = this.bookService.remove(map);
		
		if (isDeleteSuccess) {
			mav.setViewName("redirect:/list"); //삭제가 성공하면 상세페이지가 없으므로 목록으로 리다이렉트함
		} else {
			//삭제가 실패하면 다시 상세페이지로 이동함
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}

		return mav;
	}
	
	//책 목록 컨트롤러 메소드
	@RequestMapping(value = "/list")  
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		
		//책 목록을 데이터베이스에서 가져옴
		// List 안의 자료의 형식은 Map
		List <Map<String, Object>> list = this.bookService.list(map);
		
		//데이터를 뷰에 전달할 수 있게 객체에 대입함
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list);
		
		if (map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		//list 뷰를 리턴함
		mav.setViewName("/book/list");
		return mav;
	}

}
