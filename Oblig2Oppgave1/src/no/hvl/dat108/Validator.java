package no.hvl.dat108;

public class Validator {
	/**
	 * sjekker om stringen er tom, alt annet er godkjent men kj�res gjennom StringEscapeUtils.escapeHtml
	 * @param str
	 * @return om str er gyldig
	 */
	public static boolean validVarenavn(String str) {
		return !str.equals("");
	}
	
	/**
	 * Sjekker om oppgitt string kan bli omgjort til int 
	 * @param str
	 * @return om str kan gj�res om til int og om tallet er st�rre eller lik 0 (negative tall er ikek gyldig id)
	 */
	public static boolean validId(String str) {
		try {
			int i = Integer.parseInt(str);
			return i >= 0;
		}
		catch (Exception e) {
			return false;
		}
	}
}
