package cn.edu.jxnu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import cn.edu.jxnu.dao.ContactDao;
import cn.edu.jxnu.model.Contact;
import cn.edu.jxnu.model.User;

/**
 * Servlet implementation class AddContactServlet
 */
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactServlet() {
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
		DiskFileItemFactory disk = new DiskFileItemFactory();
		//2锟斤拷锟斤拷锟斤拷锟斤拷时目录
		disk.setRepository(new File("e:/dshare"));  //锟斤拷锟斤拷锟斤拷锟斤拷锟绞蹦柯硷拷锟斤拷锟斤拷锟斤拷使锟斤拷系统锟斤拷时目录锟斤拷
		//3锟斤拷 锟斤拷锟斤拷锟斤拷硬锟斤拷写锟斤拷莸幕锟斤拷锟斤拷锟斤拷小,锟斤拷锟斤拷没锟斤拷锟斤拷锟斤拷茫锟侥拷锟轿�0K锟斤拷
		disk.setSizeThreshold(1024*8);//锟斤拷锟侥硷拷锟斤拷锟节达拷锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷时目录锟斤拷锟轿筹拷锟斤拷时锟侥硷拷
		//4锟斤拷锟斤拷锟斤拷锟斤拷锟节斤拷锟斤拷锟侥讹拷锟斤拷
		ServletFileUpload upload = new ServletFileUpload(disk);
		//5锟斤拷锟斤拷锟斤拷锟较达拷锟侥硷拷锟斤拷锟斤拷锟斤拷小,锟斤拷锟斤拷嵌锟斤拷锟侥硷拷锟斤拷锟斤拷为锟斤拷锟斤拷募锟斤拷暮锟斤拷锟斤拷5M
		upload.setSizeMax(1024*1024*5);
		//锟斤拷锟斤拷httpServletRequest
		List<FileItem> items;
		try {
			Contact c1 = new Contact();
			items = upload.parseRequest(request);
			for(FileItem item:items){
				if(!item.isFormField()){
					InputStream in = item.getInputStream();
					String fname = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
					String path= getServletContext().getRealPath("upload");
					FileOutputStream os = new FileOutputStream(path+"/"+ fname);
					byte[] buff=new byte[1024];
					while(in.read(buff)!=-1){
						os.write(buff);
					}
					c1.setImgPath(fname);
				}else{ 
					String fieldName = item.getFieldName();//"name" || "phone"
					//String methName = "set"+fieldName; //setName setname //setPhone
					String fieldValue = item.getString("utf-8");//"abc"
//					Method method=Contact.class.getMethod(methName, String.class);
//					method.invoke(c1, fieldValue);
					if(fieldName.equals("name")){
						c1.setName(fieldValue);
					}else if(fieldName.equals("phone")){
						c1.setPhone(fieldValue);
					}else if(fieldName.equals("email")){
						c1.setEmail(fieldValue);
					}else if(fieldName.equals("addr")){
						c1.setAddr(fieldValue);
					}
				}
			}
			User user = (User) request.getSession().getAttribute("user"); 
			ContactDao.insert(c1,user.getId()); 
			List<Contact> ls;
			ls = ContactDao.getResults(user);
			request.setAttribute("contacts", ls);
			RequestDispatcher rd =this.getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/success.jsp");
			rd.forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	public void fn(){
		for(int i=0;i<10;i++){
			String fname = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println(fname);
		}
	}

}
