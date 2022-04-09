package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapException;

import kr.or.ddit.member.vo.MemberVO;

public class MemberDao {
	private static MemberDao dao;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDao();
		return dao;
	}
	
	public List<MemberVO> selectMember(SqlMapClient smc) throws SQLException{
		List<MemberVO> list = null;
		
		list = smc.queryForList("member.selectMember");
		
		return list;
	}
	public int checkid(SqlMapClient smc, String id)throws SQLException{
		int result = 0;
		
		result = (int)smc.queryForObject("member.checkid", id);
		
		return result;
	}
	public int insertid(SqlMapClient smc, MemberVO vo) throws SQLException{
		int result = 0;
		Object temp = smc.insert("member.insertid", vo);
		if(temp == null) {
			result = 1;
		}
		return result;
	}
	public MemberVO memberdetail(SqlMapClient smc, String id) throws SQLException{
		MemberVO vo = null;
		
		vo = (MemberVO)smc.queryForObject("member.memberdetail",id);
		
		return vo;
	}
	public int deletemember(SqlMapClient smc, String id) throws SQLException{
		int result = 0;
		
		result = smc.delete("member.deletemember", id);
		
		return result;
	}
	public int modifymember(SqlMapClient smc,MemberVO vo) throws SQLException{
		int result = 0;
		
		result = smc.update("member.modifymember", vo);
		
		return result;
	}
}
