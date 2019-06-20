package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.EditproductDao;
import com.pojo.Goods;

@WebServlet("/editpro")
public class Editproductservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("projectId");

		EditproductDao dao = new EditproductDao();

		Goods selectProduct = dao.selectProduct(id);

		request.setAttribute("producetList", selectProduct);

		request.getRequestDispatcher("admin/project_update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
