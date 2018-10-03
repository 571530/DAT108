package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static no.hvl.dat108.URLMappings.LOGIN;
import static no.hvl.dat108.URLMappings.HANDLELISTE;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");

		String feil_passord = request.getParameter("feilpassord");
		String timed_out = request.getParameter("timedout");
		String feilmelding = null;
		
		if (feil_passord != null) {
			feilmelding = "Feil passord! Prøv igjen";
		}
		else if (timed_out != null) {
			feilmelding = "For lang tid siden forrige handling, logget ut";
		}

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Logg inn</title>");
		out.println("</head>");
		out.println("<body>");

		if (feilmelding != null) {
			out.println("<p style=\"color:red\">" + feilmelding + "</p>");
		}

		out.println("<p>Gi inn passord:</p>");
		out.println("<form action=\"login\" method=\"post\">");
		out.println("<input type=\"password\" name=\"passord\"><br><br>");
		out.println("<input type=\"submit\" value=\"Logg inn\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String riktig_passord = getServletConfig().getInitParameter("passord");

		String gitt_passord = request.getParameter("passord");

		if (gitt_passord == null || !gitt_passord.equals(riktig_passord)) {
			response.sendRedirect(LOGIN + "?feilpassord");
		} else {
			HttpSession session = request.getSession(false);
			
			if (session != null) { // Hvis allerede innlogget, logg ut først
				session.invalidate();
			}
			
			int timeout = Integer.parseInt(getServletConfig().getInitParameter("timeout"));
			session = request.getSession(true);
			session.setMaxInactiveInterval(timeout);
			
			response.sendRedirect(HANDLELISTE);
		}
	}
}
