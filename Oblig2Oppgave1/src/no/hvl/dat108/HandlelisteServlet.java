package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static no.hvl.dat108.URLMappings.LOGIN;
import static no.hvl.dat108.URLMappings.HANDLELISTE;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Servlet implementation class HandlelisteServlet
 */
@WebServlet("/handleliste")
public class HandlelisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Henter handlevognen, hvis handlevognen ikke er laget blir den laget.
	 * @param session, som handlevogn hentes fra
	 * @return Handlevogn
	 */
	public Handlevogn getHandlevogn(ServletContext servletContext) {
		if (servletContext.getAttribute("liste") == null) {
			servletContext.setAttribute("liste", new Handlevogn());
		}

		Handlevogn vogn = (Handlevogn) servletContext.getAttribute("liste");
		
		return vogn;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session == null) { // timed out
			response.sendRedirect(LOGIN + "?timedout");
			return;
		}

		Handlevogn vogn = getHandlevogn(request.getServletContext()); 

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Handleliste</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2> Min handleliste </h2>");
		out.println("<form action=\"handleliste\" method=\"post\">");
		out.println("<input type=\"submit\" value=\"Legg til\"/>");
		out.println("<input type=\"text\" name=\"nyvare\"/>");
		out.println("</form><br><br>");

		// For hver vare lager vi en form med en hidden input med verdi lik iden til varen
		// Dette brukes i post for sletting
		for (Vare vare : vogn.getVarer()) {
			out.println("<form action=\"handleliste\", method=\"post\">");
			out.println("<input type=\"hidden\" name=\"slett\" value=\"" + vare.getId() + "\"/>");
			out.println("<input type=\"submit\" value=\"Slett\"/>");
			out.println(vare.getTekst());
			out.println("</form><br>");
		}

		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) { // timed out
			response.sendRedirect(LOGIN + "?timedout");
			return;
		}

		Handlevogn vogn = getHandlevogn(request.getServletContext());
		
		String vare = request.getParameter("nyvare"); 
		String slett = request.getParameter("slett");
		
		if (vare != null && Validator.validVarenavn(vare)) { // Ny vare
			synchronized(vogn) { // Synchronized for å unngå sletting og innsetting samtidig
				vogn.addVare(StringEscapeUtils.escapeHtml(vare));
			}
		}
		else if (slett != null && Validator.validId(slett)) { // Slett vare 
			int id = Integer.parseInt(slett);
			synchronized(vogn) { // Synchronized for å unngå sletting og innsetting samtidig
				vogn.removeVare(id);
			}
		}
		
		response.sendRedirect(HANDLELISTE);
	}

}
