package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.jdbcUtil;
import com.pojo.Goods;

public class AddproductDao {
		public int Addproduct(Goods goods){
			
			try {
				Connection conn = jdbcUtil.getInstace().getConn();

				String sql = "INSERT INTO `tiangou`.`goods` (`title`, `oldMoney`, `money`, `goodNumber`, `goodIntroduction`, `sellNumber`, `images`) VALUES (?,?,?,?,?,?,?) ";

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, goods.getTitle());
				ps.setString(2, goods.getOldMoney());
				ps.setString(3, goods.getMoney());
				ps.setString(4, goods.getGoodNumber());
				ps.setString(5, goods.getGoodIntroduction());
				ps.setString(6, goods.getSellNumber());
				ps.setString(7, goods.getImages());

				int res = ps.executeUpdate();
				return res;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
}
