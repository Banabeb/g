package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.jdbcUtil;

import user.pojo.user;

public class RegisterDao {
	public int insertUser(user user) {

		try {

			Connection conn = jdbcUtil.getInstace().getConn();

			String sql = "INSERT INTO `tiangou`.`user` (`account`, `password`, `email`) VALUES (?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());

			int res = ps.executeUpdate();

			return res;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
}
