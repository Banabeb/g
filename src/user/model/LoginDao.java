package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.jdbcUtil;
import user.pojo.user;
public class LoginDao {
public boolean selectUser(user user ){
		try {
			Connection conn = jdbcUtil.getInstace().getConn();
			String sql = "SELECT  * FROM  user WHERE account =? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
		     ps.setString(1, user.getAccount());
		     ps.setString(2, user.getPassword());
		     ResultSet res = ps.executeQuery();
		     
		   
		     return  res.next();
		     
		     
		     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}
}
