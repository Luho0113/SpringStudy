package sample.spring.yse;

import java.util.List;
import java.util.Map;

public interface BookService {
	String create(Map<String, Object> map);
	
	//책 상세 서비스 인터페이스 메소드 시그니처
	Map<String, Object> detail(Map<String, Object> map);

	//책 수정 기능 서비스 인터페이스
	boolean edit(Map<String, Object> map);
	
	//책 삭제 기능 서비스 인터페이스
	boolean remove(Map<String, Object> map);
	
	
	//책 목록 기능 서비스 인터페이스
	List<Map<String, Object>> list(Map<String, Object> map); 
	
	
}
