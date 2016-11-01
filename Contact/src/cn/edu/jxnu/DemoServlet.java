package cn.edu.jxnu;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DemoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub 
		InputStream is =this.getServletConfig().getServletContext().getResourceAsStream("/config/dc.cfg");
	
		Properties prop = new Properties();
		prop.load(is);
		
		System.out.println(prop.get("drvier"));
		ServletConfig scf = this.getServletConfig();
		ServletContext sc = scf.getServletContext();
		URL url = sc.getResource("/");
		String cty=sc.getInitParameter("country");
		System.out.println(sc.getRealPath("/"));
		String temp = req.getParameter("temp");
		PrintWriter out = resp.getWriter();
		sc.setAttribute("temp1", temp);
		
		out.write("temperature:"+temp);
		out.write("country:"+cty); 
	}

	public DemoServlet() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("construct demoservlet");
	}
	
}
