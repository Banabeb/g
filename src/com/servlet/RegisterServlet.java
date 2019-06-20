package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.model.RegisterDao;
import com.pojo.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     User user = accept(request);
			RegisterDao dao = new RegisterDao();
			int res = dao.insertUser(user);
			JSONObject jo = new JSONObject();
			jo.put("success", res);
			response.getWriter().println(jo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	public User accept(HttpServletRequest request){
		String username = request.getParameter("userName");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		User user = 	new User();
		user.setUsername(username);
		user.setAccount(account);
		user.setPassword(password);
		user.setPhone(phone);
		
		return  user ; 
	}

}
