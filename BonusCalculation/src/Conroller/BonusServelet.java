package Conroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Business.BonusCalculateBusiness;


@WebServlet("/BonusServelet")
public class BonusServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int epf, experience , salary;

		epf = Integer.parseInt( request.getParameter("epf"));
		experience = Integer.parseInt(request.getParameter("experience"));
		salary = Integer.parseInt(request.getParameter("salary"));

		BonusCalculateBusiness business = new BonusCalculateBusiness();
		
		
		double result = business.previousBonus(epf);
		
		if (result > 0) {
			
			request.setAttribute("bonus", result);
			request.getRequestDispatcher("ViewBonus.jsp").forward(request, response);

			return;
		} else {
			double bonus = business.inserBonus(epf, experience , salary);
			request.setAttribute("bonus", bonus);
			request.getRequestDispatcher("ViewBonus.jsp").forward(request, response);
		}
	}

}
