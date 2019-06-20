package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbcUtil {
	static  jdbcUtil  ju =null ;

    Connection connection ;

    private jdbcUtil(){
	   
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tiangou?characterEncoding=utf8";
			String name = "root";
			String password = "123456";

			 connection = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
   }

   public static  jdbcUtil getInstace(){

	   if (ju == null ) {
		   ju =    new jdbcUtil();
    	}
	   
	   return ju ; 
   }

  public Connection  getConn(){

	  return connection;
  }

  public void  setCloseConn(Connection conn){
	  
	  if (conn !=null) {	
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  
  }
  public void setClosePs(PreparedStatement ps){
	  
	  if (ps != null) {
		
		  try {
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
	  
  }
}
