package org.zerock.web.dao;

import org.zerock.web.vo.MemberVO;

public interface MemberDAO {
	
	public String getTime();
	public void insertMember(MemberVO vo);

}
