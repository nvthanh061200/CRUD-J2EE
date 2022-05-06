package Controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Models.Model;
import Obj.SinhVien;; 
//@WebServlet("/LapServlet")
public class LapServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = new Model();
		List<SinhVien> list = model.getAll();
		request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp");
        dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
