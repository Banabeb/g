package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.jdbcUtil;
import com.pojo.Goods;


public class Updataproduct {
public int updateGoods(Goods goods){
		
		try {

			Connection conn = jdbcUtil.getInstace().getConn();

			String sql = "UPDATE `tgou`.`goods` SET `title` = ?, `oldMoney` = ?,`money` = ? , `goodNumber` = ? , `goodIntroduction` = ? , `sellNumber` =? , `images` = ? WHERE `id` = ? ";

			PreparedStatement ps = conn.prepareStatement(sql);

			System.out.println(goods);
			if (goods.getTitle()!=null) {
				ps.setString(1, goods.getTitle());
			}
			if (goods.getOldMoney()!=null) {
				ps.setString(2, goods.getOldMoney());
			}
			
			ps.setString(3, goods.getMoney());
			ps.setString(4, goods.getGoodNumber());
			ps.setString(5, goods.getGoodIntroduction());
			ps.setString(6, goods.getSellNumber());
			ps.setString(7, goods.getImages());
			ps.setInt(8, goods.getId());
			int res = ps.executeUpdate();

			return res;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
