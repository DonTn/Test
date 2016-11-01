package cn.edu.jxnu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1、创建一个基于硬盘的工厂
		DiskFileItemFactory disk = new DiskFileItemFactory();
		//2、设置临时目录
		disk.setRepository(new File("d:/a"));  //建议设计临时目录，否则会使用系统临时目录。
		//3、 设置向硬盘写数据的缓冲区大小,如果用户不设置，默认为10K。
		disk.setSizeThreshold(1024*8);//当文件大于此设置时，将会在临时目录下形成临时文件
		//4、创建用于解析的对像
		ServletFileUpload upload = new ServletFileUpload(disk);
		//5、设置上传文件的最大大小,如果是多个文件，则为多个文件的和最大5M
		upload.setSizeMax(1024*1024*5);
		//解析httpServletRequest
		List<FileItem> items;
		try {
			items = upload.parseRequest(request);			
			FileItem item = items.get(0);//处理第一个文件
			//获取完整文件名
			String fileName = item.getName();
			//仅获取文件名
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
			//获取输入流
			InputStream in = item.getInputStream(); 
			String path= getServletContext().getRealPath("upload");
			FileOutputStream os = new FileOutputStream(path+"/"+fileName);
			byte[] buff=new byte[1024];
			while(in.read(buff)!=-1){
				os.write(buff);
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//处理文件上传 

	}

}
