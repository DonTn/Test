package cn.edu.jxnu.dao;

 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.PreparedStatement;

import cn.edu.jxnu.model.Contact;
import cn.edu.jxnu.model.User;
import cn.edu.jxnu.util.DbUtil;

 

public class ContactDao { 
	public void listContact() throws SQLException{
		Connection conn=null ;
		try {   
			conn = DbUtil.getConnection();
			Statement state = conn.createStatement();
			ResultSet rs;
			if( state.execute("select id,phone,name from contact_t")==true){
				rs=state.getResultSet();
				while(rs.next()){
					System.out.println(rs.getString(2));
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn==null){
				conn.close();
				conn = null;
			}
		}
	}

	

	public static List<Contact> getResults(User u){
		 
		// TODO Auto-generated method stub
		List<Contact> ls=new ArrayList<Contact>();
		Connection conn=null;
		try {			 
			conn = DbUtil.getConnection();			
			Statement stm = conn.createStatement();
			String sql="select * from contact_t where userid="+u.getId();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){ 
				Contact c = new Contact();
				c.setName(rs.getString("name")); 
				c.setId(rs.getInt("Id"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setAddr(rs.getString("addr"));
				c.setImgPath(rs.getString("img"));
				ls.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ls;
	}



	public static boolean delete(String[] ids) {
		// TODO Auto-generated method stub
		boolean ret = false;
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			String sql= "delete from contact_t where id =?";
			Statement st = conn.createStatement();
			 
			for(String id:ids){ 				 
				st.addBatch("delete from contact_t where id ="+id); 
			}   
			st.executeBatch();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}



	public static boolean insert(Contact c1,int uid) {
		// TODO Auto-generated method stub
		boolean ret = false;
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			String sql= "insert into  contact_t(name,phone,email,addr,img,userid) values(?,?,?,?,?,?) ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, c1.getName());
			pst.setString(2, c1.getPhone());
			pst.setString(3, c1.getEmail());
			pst.setString(4, c1.getAddr());
			pst.setString(5, c1.getImgPath());
			pst.setInt(6, uid);
			ret = pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}



	public static boolean update(Contact ct) {
		// TODO Auto-generated method stub
		boolean ret = false;
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			String sql= "update  contact_t set name=?,phone=?,email=?,addr=? where id=?  ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, ct.getName());
			pst.setString(2, ct.getPhone());
			pst.setString(3, ct.getEmail());
			pst.setString(4, ct.getAddr()); 
			pst.setInt(5, ct.getId());
			ret = pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}
}
