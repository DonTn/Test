package cn.edu.jxnu;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import cn.edu.jxnu.dao.ContactDao;
import cn.edu.jxnu.dao.UserDao;
import cn.edu.jxnu.model.Contact;
import cn.edu.jxnu.model.User;

/**
 * Servlet implementation class CheckServlet
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private int a;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		String user=request.getParameter("username");
		String pwd = request.getParameter("password");
		String tm = request.getParameter("lt");
		User u = UserDao.getUser(user, pwd);
		
		if(u!=null){ 
			Cookie ck = new Cookie("usname", user);
			Cookie ck2 = new Cookie("pwd", pwd);
			int t = Integer.parseInt(tm);
			t=t*24*60*60;
			ck.setMaxAge(t);
			ck2.setMaxAge(t);
			response.addCookie(ck);
			response.addCookie(ck2); 
			
			RequestDispatcher rd =this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/success.jsp");
			request.getSession().setAttribute("user", u);
			rd.forward(request, response); 
		}else{
			RequestDispatcher rd =this.getServletConfig().getServletContext().getRequestDispatcher("/login.html");
			rd.forward(request, response);	
		} 
		
	}

}
