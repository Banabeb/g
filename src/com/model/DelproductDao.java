package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.jdbcUtil;

public class DelproductDao {
public int deleteProduct(String id){
		
		try {
			Connection conn = jdbcUtil.getInstace().getConn();
			String sql="DELETE FROM goods WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int res = ps.executeUpdate();
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
