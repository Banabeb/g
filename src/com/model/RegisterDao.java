package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.jdbcUtil;
import com.pojo.User;
public class RegisterDao {
	Connection conn;
	PreparedStatement ps;

	public int insertUser(User user) {
		try {
			conn = jdbcUtil.getInstace().getConn();
			String sql = "INSERT INTO admin (`name`,`account`, `password`, `phone`) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getAccount());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
		
			int res = ps.executeUpdate();
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

}
