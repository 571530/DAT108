package no.hvl.dat108;

public class Skjema {
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String kjonn;
	private String passord;
	private String passordRepetert;
	private boolean mobilLedig;
	
	Skjema() {
		
	}
	
	/**
	 * @param fornavn
	 * @param etternavn
	 * @param mobil
	 * @param kjonn
	 * @param passord
	 * @param passordRepetert
	 */
	public Skjema(String fornavn, String etternavn, String mobil, String kjonn, String passord, String passordRepetert) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.kjonn = kjonn;
		this.passord = passord;
		this.passordRepetert = passordRepetert;
	}
	
	
	/**
	 * Lager en deltager utifra opplysningene, krypterer også passord til lagring i database
	 * @return deltager
	 */
	Deltager lagDeltager() {
		String salthash = PassordUtil.krypterPassord(passord);
		
		return new Deltager(getFornavn(), getEtternavn(), getKjonn(), getMobil(), salthash);
	}
	
	/**
	 * lager et skjema uten passord for å lagre i session
	 * @return nytt skjema med riktige verdier men uten passord
	 */
	SkjemaResultat lagSkjemaResultat() {
		return new SkjemaResultat(
				isFornavnGyldig() ? fornavn : "",
				isEtternavnGyldig() ? etternavn : "",
				isMobilGyldig() ? mobil : "",
				isKjonnGyldig() ? kjonn : "",
				isPassordGyldig(),
				isPassordRepetert(),
				isMobilLedig());
				
			
	}
	
	/**
	 * @return the mobilBrukt
	 */
	public boolean isMobilLedig() {
		return mobilLedig;
	}

	/**
	 * @param mobilBrukt the mobilBrukt to set
	 */
	public void setMobilLedig(boolean mobilledig) {
		this.mobilLedig = mobilledig;
	}

	public boolean isFornavnGyldig() {
		return Validator.validFornavn(fornavn);
	}

	
	public boolean isEtternavnGyldig() {
		return Validator.validEtternavn(etternavn);
	}
	
	public boolean isMobilGyldig() {
		return Validator.validMobil(mobil);
	}
	
	public boolean isKjonnGyldig() {
		return Validator.validKjonn(kjonn);
	}
	
	public boolean isPassordGyldig() {
		return Validator.validPassord(passord);
	}
	
	public boolean isPassordRepetert() {
		return passord.equals(passordRepetert);
	}
	
	/**
	 * @return the fornavn
	 */
	public String getFornavn() {
		return fornavn;
	}
	/**
	 * @param fornavn the fornavn to set
	 */
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	/**
	 * @return the etternavn
	 */
	public String getEtternavn() {
		return etternavn;
	}
	/**
	 * @param etternavn the etternavn to set
	 */
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	/**
	 * @return the mobil
	 */
	public String getMobil() {
		return mobil;
	}
	/**
	 * @param mobil the mobil to set
	 */
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	/**
	 * @return the kjonn
	 */
	public String getKjonn() {
		return kjonn;
	}
	/**
	 * @param kjonn the kjonn to set
	 */
	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
}	

