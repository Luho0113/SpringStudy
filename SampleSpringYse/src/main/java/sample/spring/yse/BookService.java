package sample.spring.yse;

import java.util.List;
import java.util.Map;

public interface BookService {
	String create(Map<String, Object> map);
	
	//å �� ���� �������̽� �޼ҵ� �ñ״�ó
	Map<String, Object> detail(Map<String, Object> map);

	//å ���� ��� ���� �������̽�
	boolean edit(Map<String, Object> map);
	
	//å ���� ��� ���� �������̽�
	boolean remove(Map<String, Object> map);
	
	
	//å ��� ��� ���� �������̽�
	List<Map<String, Object>> list(Map<String, Object> map); 
	
	
}
