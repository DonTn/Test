package cn.edu.jxnu.dao;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 




import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import cn.edu.jxnu.model.Contact;
import cn.edu.jxnu.model.User;
import cn.edu.jxnu.util.DbUtil;

public class UserDao {
	public static User getUser(String username,String pwd){
		User u = null;
		Connection conn = null;
		try {  
			conn =DbUtil.getConnection();
			String sql="select * from user_t where  username=?  and pwd=?";
			PreparedStatement pst =conn.prepareStatement(sql);
			
			pst.setString(1, username);
			pst.setString(2, pwd); 
			 
			ResultSet rs = pst.executeQuery();
			while(rs.next()){ 
				u = new User();
				u.setId(rs.getInt("Id"));
				u.setPwd(pwd);
				u.setUname(username);
			}
		} catch (Exception e) {
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
		return u;
	}

	public static boolean insert(User user) {
		// TODO Auto-generated method stub
		 boolean ret = false;
		Connection conn = null;
		try {  
			conn =DbUtil.getConnection();
			String sql="insert into user_t(username,pwd) values(?,?)";
			PreparedStatement pst =conn.prepareStatement(sql);
			
			pst.setString(1, user.getUname());
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(user.getPwd().getBytes());
			
			pst.setString(2, new String(digest)); 
			 
		    ret =  pst.execute();
			 
		} catch (Exception e) {
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
