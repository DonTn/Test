package cn.edu.jxnu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Cookies;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cks =request.getCookies();
		if(cks!=null){
			for(Cookie ck:cks){
				System.out.println(ck.getName()+":"+ck.getValue());
			}
		}
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		if(session.getAttribute("user") == null){
			response.sendRedirect("login.jsp");
		}else{
			String tokenString =request.getParameter("token");
			if(!tokenString.equals("abcdefg")){
				response.sendRedirect("error");
			}
			InputStream in = this.getServletContext().getResourceAsStream("/download/aaa.doc");
			response.setContentType("application/msword"); 
			response.setHeader("content-disposition", "attachment; filename=aaa.doc");
			OutputStream out = response.getOutputStream(); 
			byte[] buff=new byte[1024];		
			while(in.read(buff)>0){
				out.write(buff);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
