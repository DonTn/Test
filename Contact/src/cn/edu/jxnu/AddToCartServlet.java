package cn.edu.jxnu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int app = Integer.parseInt(request.getParameter("apple"));
		int pear =  Integer.parseInt( request.getParameter("pear"));
		int banana =  Integer.parseInt(request.getParameter("banana"));
		
		Cookie[] cookies =request.getCookies();
		int apps=0;
		int pears=0;
		int bananas=0;
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("pear")){
					pears=  Integer.parseInt(c.getValue());
				}
				
				if(c.getName().equals("apple")){
					apps=  Integer.parseInt(c.getValue());
				}
				if(c.getName().equals("banana")){
					bananas= Integer.parseInt( c.getValue());
				}
			}
		}
		
		apps+=app;
		pears+=pear;
		bananas+=banana;
		
		Cookie c1 = new Cookie("apple", apps+"");
		c1.setMaxAge(60);
		c1.setPath("/abc");
		Cookie c2 = new Cookie("pear", pears+"");
		c2.setMaxAge(60);
		Cookie c3 = new Cookie("banana", bananas+"");
		response.setContentType("text/html;charset= utf-8");
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		
		PrintWriter out = response.getWriter();
		out.print("Æ»¹û:"+apps);
		out.print("Àæ×Ó:"+pears);
		out.print("Ïã½¶:"+bananas);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
