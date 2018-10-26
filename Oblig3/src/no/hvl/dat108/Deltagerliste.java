package no.hvl.dat108;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Paamelding
 */
@WebServlet("/deltagerliste")
public class Deltagerliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerEAO deltagerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession(false) == null || request.getSession(false).getAttribute("deltager") == null) {
			response.sendRedirect("paamelding");
		} else {
			request.setAttribute("deltagere",
					deltagerEAO.hentDeltagere().stream()
							.sorted(Comparator.comparing(Deltager::getEtternavn).thenComparing(Deltager::getFornavn))
							.collect(Collectors.toList()));

			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("deltagerliste");
	}

}
