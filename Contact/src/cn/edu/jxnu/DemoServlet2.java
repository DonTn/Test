package cn.edu.jxnu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet2
 */
public class DemoServlet2 extends HttpServlet  {
	private static final long serialVersionUID = 1L;
       private int cnt;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet2() {  
        super();
      	System.out.println("construct servlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Calendar cd =   Calendar.getInstance();
		String strMsg; 
	    response.setContentType("text/html; charset=GB2312");
	  
		if(cd.getTime().getHours()>=12){
			strMsg = "早上好 ,good afternoon";
		}else{
			strMsg = "hello ,下午好";
		}
		PrintWriter out = response.getWriter();
		
		String st = (String) this.getServletConfig().getServletContext().getAttribute("temp1");
		out.write("<html>");
		out.write("<head><title>hello</title></head>");
		out.write(strMsg);
		out.write("temp="+st);
		
		out.write("</html>");
	}

 
	 
}
