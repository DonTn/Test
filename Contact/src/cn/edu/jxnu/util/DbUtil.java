package cn.edu.jxnu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.edu.jxnu.dao.ContactDao;

public class DbUtil {
	private static  ComboPooledDataSource ds = new ComboPooledDataSource();
	
	public static Connection getConnection()  {
					
		Connection conn=null;
		try{
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
