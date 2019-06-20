package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.jdbcUtil;
import com.pojo.Goods;
import com.pojo.Product;

public class EditproductDao {
		public Goods selectProduct(String pid){
			try {
				Connection conn = jdbcUtil.getInstace().getConn();
				String sql="select * from goods where id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, pid);
				ResultSet res = ps.executeQuery();
				if(res.next()){
					int id = res.getInt("id");
					String title = res.getString("title");
					String oldMoney = res.getString("oldMoney");
					String money = res.getString("money");
					String goodNumber = res.getString("goodNumber");
					String goodIntroduction = res.getString("goodIntroduction");
					String sellNumber = res.getString("sellNumber");
					String images = res.getString("images");
					Goods goods = new Goods();
					goods.setId(id);
					goods.setTitle(title);
					goods.setOldMoney(oldMoney);
					goods.setMoney(money);
					goods.setGoodNumber(goodNumber);
					goods.setGoodIntroduction(goodIntroduction);
					goods.setSellNumber(sellNumber);
					goods.setImages(images);
					return goods;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
}
