package cn.edu.jxnu;

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchSerlvet
 */
public class SearchSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSerlvet() {
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
	//	request.setCharacterEncoding("gbk");
		String key =request.getParameter("key");
		key = new String(key.getBytes("iso8859-1"),"gbk");
		List<Book> ls = new ArrayList<Book>();
		Book b1 = new Book(20.2,"tsinghua university", "张三丰", "java入门教程");
		ls.add(b1);
		Book b2= new Book(30.2,"北京邮电大学出版社", "方兴摒", "java入门教程");
		ls.add(b2);
		request.setAttribute("books", ls);
		request.setAttribute("key", key);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}

}
