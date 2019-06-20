package user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import user.model.LoginDao;
import user.pojo.user;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user user = accept(request);

		LoginDao dao = new LoginDao();

		boolean res = dao.selectUser(user);

		JSONObject jo = new JSONObject();

		if (res) {
			jo.put("resultCode", 1);
			jo.put("message", "登陆成功");
			
		} else {
			jo.put("resultCode", 0);
			jo.put("message", "你太丑，不能登陆");
		}

		response.getWriter().print(jo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public user accept(HttpServletRequest request) {

		String account = request.getParameter("account");
		String password = request.getParameter("password");

		user user = new user();
		user.setAccount(account);
		user.setPassword(password);

		return user;
	}
}
