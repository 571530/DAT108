package no.hvl.dat108;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ferdig
 */
@WebServlet("/ferdig")
public class Ferdig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession(false) != null) {
			request.getSession().invalidate();
		}
		
		request.getRequestDispatcher("WEB-INF/ferdig.jsp").forward(request, response);
	}

}
