package cn.edu.jxnu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

/**
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet2() {
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
		
		int apps =0;
		int pears =0;
		int bananas =0;
		HttpSession  cart = request.getSession();
		Map<String,Integer> map = (Map<String, Integer>) cart.getAttribute("cart");
		if(map!=null){
			apps = map.get("apples");
			pears = map.get("pears");
			bananas = map.get("bananas");
		}
		
		
		if(map ==null){
			map = new HashMap<String, Integer>();
			
		}
		apps+=app;
		pears+=pear;
		bananas+=banana;
		
	    map.put("appples", apps);
	    map.put("pears", pears);
	    map.put("bananas", bananas);
	    cart.setAttribute("cart", map);
	    
		response.setContentType("text/html;charset= utf-8");
	 
		
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
