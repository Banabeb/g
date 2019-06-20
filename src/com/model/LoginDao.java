package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.jdbcUtil;
import com.pojo.User;

public class LoginDao {
	Connection conn;
	PreparedStatement ps;

	public boolean selectUser(User user) {
		try {
			conn = jdbcUtil.getInstace().getConn();
			String sql = "SELECT * FROM admin where account=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			
			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
		

	}
}
