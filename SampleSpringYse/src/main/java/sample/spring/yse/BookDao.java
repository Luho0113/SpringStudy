package sample.spring.yse;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	
	//�ʵ� ����
	@Autowired //�ڵ�����
	SqlSessionTemplate sqlSessionTemplate;
	
	
	//(resources/book_SQL.xml�� �޼ҵ� id, MySQL)
	//å ������ �Է� ������ �����ϴ� DAO �޼ҵ�
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("book.insert", map);
	}
	
	//å �� DAO �޼ҵ�
	public Map<String, Object> selectDetail(Map<String, Object> map) {
	    return this.sqlSessionTemplate.selectOne("book.select_detail", map);
	}
	
	//å ���� ��� DAO �޼ҵ�
	public int update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("book.update", map);
	}
	
	//å ���� ��� DAO �޼ҵ�
	public int delete(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("book.delete", map);
	}
	
	//å ��� DAO �޼ҵ�
	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("book.select_list", map);
	}

}
