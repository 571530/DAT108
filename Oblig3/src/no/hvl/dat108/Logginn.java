package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logginn
 */
@WebServlet("/logginn")
public class Logginn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerEAO deltagerEAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Hvis allerede logget inn, logg ut personen
		if (request.getSession(false) != null) {
			request.getSession(false).invalidate();
		}
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobil = request.getParameter("mobil");
		String pass = request.getParameter("passord");
		
		Deltager deltager = deltagerEAO.hentDeltager(mobil);
		
		// Hvis funnet bruker og passorsdet er riktig
		if (deltager != null && PassordUtil.sjekkPassord(pass, deltager.getPass())) {
			request.getSession(true);
			request.getSession(false).setAttribute("deltager", deltager);
			
			response.sendRedirect("deltagerliste");
		}
		else {
			response.sendRedirect("logginn?invalid=true");
		}
	}

}
