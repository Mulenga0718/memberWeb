package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberService {
	private MemberDao dao;
	private static MemberService service;
	
	private MemberService() {
		dao = MemberDao.getInstance();
	}
	public static MemberService getInstance() {
		if(service == null) service = new MemberService();
		return service;
	}
	
	public List<MemberVO> selectMember(){
		SqlMapClient smc = null;
		List<MemberVO> list = null;
		
		try {
		smc = SqlMapClientFactory.getsqlMapClient();
		list = dao.selectMember(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int checkid(String id){
		SqlMapClient smc = null;
		int result = 0;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = dao.checkid(smc, id);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public int insertid(MemberVO vo) {
		SqlMapClient smc = null;
		int result = 0;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = dao.insertid(smc, vo);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public MemberVO memberdetail(String id){
		SqlMapClient smc = null;
		MemberVO vo = null;
		
		try {
		smc = SqlMapClientFactory.getsqlMapClient();
		vo = dao.memberdetail(smc, id);
		} catch (SQLException e) {
		 e.printStackTrace();
		}
		return vo;
	}
	public int deletemember(String id){
		SqlMapClient smc = null;
		int result = 0;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = dao.deletemember(smc, id);
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		
		return result;
	}
	public int modifymember(MemberVO vo){
		SqlMapClient smc = null;
		int result = 0;
		
		try {
			smc = SqlMapClientFactory.getsqlMapClient();
			result = dao.modifymember(smc, vo);
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		
		
		return result;
	}
}
