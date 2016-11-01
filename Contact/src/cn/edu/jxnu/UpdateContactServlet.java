package cn.edu.jxnu;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.jxnu.dao.ContactDao;
import cn.edu.jxnu.model.Contact;
import cn.edu.jxnu.model.User;

/**
 * Servlet implementation class UpdateContactServlet
 */
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		Contact ct = new Contact();
		String name  =request.getParameter("name");
		ct.setName(name);
		String phone = request.getParameter("phone");
		ct.setPhone(phone);
		String email = request.getParameter("email");
		ct.setEmail(email);
		String  addr = request.getParameter("addr");
		ct.setAddr(addr);
		String id = request.getParameter("id");
		ct.setId(Integer.parseInt(id));
		ContactDao.update(ct);
		User user = (User) request.getSession().getAttribute("user"); 
		List<Contact> ls;
		ls = ContactDao.getResults(user);
		request.setAttribute("contacts", ls);
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);
	}

}
