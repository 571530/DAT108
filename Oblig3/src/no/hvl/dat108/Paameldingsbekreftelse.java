package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Paamelding
 */
@WebServlet("/paameldingsbekreftelse")
public class Paameldingsbekreftelse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession(false) == null || request.getSession(false).getAttribute("deltager") == null) {
			response.sendRedirect("paamelding");
		} else {
			request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
		}
	}
}
