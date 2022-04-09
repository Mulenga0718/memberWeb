package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class Updatemember2
 */
@WebServlet("/updatemember2.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024*10,
		maxFileSize = 1024*1024*30,
		maxRequestSize = 1024*1024*50
		)

public class Updatemember2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberService service = MemberService.getInstance();
		MemberVO vo = new MemberVO();
		String id =request.getParameterValues("id")[0];
	
		vo.setMem_id(id);
		vo.setMem_pass(request.getParameter("pass"));
		vo.setMem_name(request.getParameter("name"));
		vo.setMem_tel(request.getParameter("tel"));
		vo.setMem_addr(request.getParameter("addr"));
		String fileName = ""; //파일명이 저장될 변수명 
		String uploadPath = "d:/d_other/memberphoto";
		List<Fileinfo> list = new ArrayList<Fileinfo>();
		

		 //전체 Part객체 개수만큼 반복 	
		 for(Part part : request.getParts()) {
			 // 1개의 업로드 파일 정보를 구한다. 
			 fileName = extractFilename(part);
			 
			 if(!fileName.equals("")) {
			 
				 Fileinfo finfo = new Fileinfo();
				 finfo.setFileName(fileName);
				 finfo.setFileSize((int)Math.ceil((part.getSize()/1024.0)));
				 try {
					 //Upload된 파일을 서버쪽 저장장소에 저장한다. 
					 part.write(uploadPath+File.separator+fileName);
					 finfo.setStatus("Success");
				} catch (IOException e) {
					finfo.setStatus("fail : " +e.getMessage());
					
				}
				 list.add(finfo); // 파일 정보를 List에 추가
			 }
		 }
		 	vo.setMem_photo(fileName);
		int result = service.modifymember(vo);
		
			response.sendRedirect(request.getContextPath()+"/member/start.jsp");
			
	
	}
	
	private String extractFilename(Part part) {
		String fileName = "";
		
		//각 Part의 Content-Dispostion의 값 구하기 
		String contentDispostion =
				part.getHeader("Content-Disposition");
		String[] items = contentDispostion.split(";");
		for(String item : items) {
			// 파일 정보 찾기 
			if(item.trim().startsWith("filename")) {
				// fileName="test1.txt"
				fileName = item.substring(item.indexOf("=")+2,item.length()-1);
			}
		}
		
		return fileName;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
