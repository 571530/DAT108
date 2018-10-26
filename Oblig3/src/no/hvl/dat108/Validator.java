package no.hvl.dat108;

public class Validator {
	
	/**
	 * Passord må ha en lengde større enn 4
	 * @param passord
	 * @return
	 */
	public static boolean validPassord(String passord) {
		return passord != null && passord.length() > 4;
	}
	
	/**
	 * Tester om mobilnummeret er korrekt med åtte siffere
	 * @param mobil
	 * @return
	 */
	public static boolean validMobil(String mobil) {
		return mobil != null && mobil.matches("^[0-9]{8}");
	}
	
	/**
	 * Tester om kjonnet er enten mann eller kvinne
	 * @param kjonn
	 * @return
	 */
	public static boolean validKjonn(String kjonn) {
		return "kvinne".equals(kjonn) || "mann".equals(kjonn);
	}
	
	/**
	 * Tester om gitt streng er et gyldig fornavn
	 * Må starte med stor bokstav og inneholde bokstaver, " ", eller -
	 * Minimums lengde 2, maxs 20
	 * @param navn
	 * @return
	 */
	public static boolean validFornavn(String navn) {
		return navn != null && navn.length() <= 20 && navn.matches("^([A-ZØÆÅ][\\-\\sa-zA-ZæøåÆØÅ]+)");
	}
	
	/**
	 * Tester om gitt streng er et gyldig etternavn
	 * Må starte med stor bokstav og inneholde bokstaver, eller -
	 * Minimums lengde 2, maxs 20
	 * @param navn
	 * @return
	 */
	public static boolean validEtternavn(String navn) {
		return navn != null && navn.length() <= 20 && navn.matches("^([A-ZØÆÅ][\\sa-zA-ZæøåÆØÅ]+)");
	}
}
