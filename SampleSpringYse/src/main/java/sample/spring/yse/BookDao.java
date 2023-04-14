package sample.spring.yse;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	
	//필드 선언
	@Autowired //자동주입
	SqlSessionTemplate sqlSessionTemplate;
	
	
	//(resources/book_SQL.xml의 메소드 id, MySQL)
	//책 데이터 입력 쿼리를 실행하는 DAO 메소드
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("book.insert", map);
	}
	
	//책 상세 DAO 메소드
	public Map<String, Object> selectDetail(Map<String, Object> map) {
	    return this.sqlSessionTemplate.selectOne("book.select_detail", map);
	}
	
	//책 수정 기능 DAO 메소드
	public int update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("book.update", map);
	}
	
	//책 삭제 기능 DAO 메소드
	public int delete(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("book.delete", map);
	}
	
	//책 목록 DAO 메소드
	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectList("book.select_list", map);
	}

}
