package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Paamelding
 */
@WebServlet("/paamelding")
public class Paamelding extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerEAO deltagerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("skjema"); // Fjern skjema hvis den finnes fra før
		
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String kjonn = request.getParameter("kjonn");
		String passord = request.getParameter("passord");
		String passordRepetert = request.getParameter("passordRepetert");

		Skjema skjema = new Skjema(fornavn, etternavn, mobil, kjonn, passord, passordRepetert);
		// Kun sjekke om mobilen er brukt i databasen hvis mobilen er gyldig, ellers risikerer vi sql injections.
		skjema.setMobilLedig(skjema.isMobilGyldig() ? deltagerEAO.erMobilLedig(mobil) : false); 

		SkjemaResultat skjemaResultat = skjema.lagSkjemaResultat();
		
		if (skjemaResultat.isAlleGyldige()) {
			if (request.getSession(false) != null) {
				request.getSession(false).invalidate();
			}
			HttpSession session = request.getSession(true);
			
			Deltager deltager = skjema.lagDeltager();
			
			deltagerEAO.registrerDeltager(deltager);
			
			session.setAttribute("deltager", deltager);
			
			response.sendRedirect("paameldingsbekreftelse");
		}
		else {
			request.getSession().setAttribute("skjema", skjema.lagSkjemaResultat());
			
			response.sendRedirect("paamelding");
		}
		
	}
}