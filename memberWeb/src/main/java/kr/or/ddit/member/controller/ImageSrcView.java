package kr.or.ddit.member.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageSrcView
 */
@WebServlet("/imageSrcView.do")
public class ImageSrcView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			String filename = request.getParameter("filename");
			
			
			String dowloadPath = "d:/d_other/memberphoto";
			String filePath = dowloadPath + File.separator+filename;
			
			File file = new File(filePath);
			
			
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			
			if(file.exists()) {
				try {
					//출력용 스트림  
					bos = new BufferedOutputStream(response.getOutputStream());
					
					//입력용 스트림 
					bis = new BufferedInputStream(new FileInputStream(file));
					
					byte[] temp = new byte[1024];
					int len = 0;
					while((len=bis.read(temp))>0) {
						bos.write(temp,0,len);
					}
					bos.flush();
					
				} catch (IOException e) {
					System.out.println("입출력 오류 : " + e.getMessage());
				}finally {
					if(bis !=null)try {bis.close();}catch(IOException e) {}
					if(bos !=null)try {bos.close();}catch(IOException e) {}
				}
				
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}