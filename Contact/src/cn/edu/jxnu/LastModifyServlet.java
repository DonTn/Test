package cn.edu.jxnu;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastModifyServlet
 */
public class LastModifyServlet extends HttpServlet {
	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String path = this.getServletContext().getRealPath("/imgs/demo.txt");
		File file=new File(path);
		long tm = file.lastModified();
		return tm;
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LastModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InputStream is = this.getServletContext().getResourceAsStream("/imgs/demo.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		 
		String line = br.readLine();
		PrintWriter out= response.getWriter();
		out.println(line);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
