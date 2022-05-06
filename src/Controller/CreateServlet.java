package Controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Model;
import Obj.SinhVien;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher sis = request.getServletContext().getRequestDispatcher("/WEB-INF/create.jsp");
		sis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "";
		request.setCharacterEncoding("UTF-8");
		try {
			name = request.getParameter("name").toString();
			
		}catch(Exception e) {
			name = "";
		}
		
		SinhVien sv = new SinhVien("",name);
		Model model = new Model();
		if(model.insert(sv)) {
			response.sendRedirect(request.getContextPath() + "/getAll");
		}
		else {
			request.setAttribute("Object", sv);
			RequestDispatcher sis = request.getServletContext().getRequestDispatcher("/WEB-INF/create.jsp");
			sis.forward(request, response);
		}
	}
}
