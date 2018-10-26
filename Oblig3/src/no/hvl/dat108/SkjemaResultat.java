package no.hvl.dat108;

public class SkjemaResultat {
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String kjonn;
	private boolean passordGyldig;
	private boolean passordRepetert;
	private boolean mobilLedig;
	/**
	 * @return the fornavn
	 */
	public String getFornavn() {
		return fornavn;
	}
	
	public SkjemaResultat() {
		
	}
	
	boolean isAlleGyldige() {
		return fornavn != "" && etternavn != "" && kjonn != "" && mobil != "" && passordGyldig && passordRepetert && mobilLedig;
	}
	
	/**
	 * @param fornavn
	 * @param etternavn
	 * @param mobil
	 * @param kjonn
	 * @param passordGyldig
	 * @param passordRepetert
	 * @param mobilLedig
	 */
	public SkjemaResultat(String fornavn, String etternavn, String mobil, String kjonn, boolean passordGyldig,
			boolean passordRepetert, boolean mobilLedig) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.kjonn = kjonn;
		this.passordGyldig = passordGyldig;
		this.passordRepetert = passordRepetert;
		this.mobilLedig = mobilLedig;
	}
	/**
	 * @return the mobilLedig
	 */
	public boolean isMobilLedig() {
		return mobilLedig;
	}

	/**
	 * @param mobilLedig the mobilLedig to set
	 */
	public void setMobilLedig(boolean mobilLedig) {
		this.mobilLedig = mobilLedig;
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
	/**
	 * @return the passordGyldig
	 */
	public boolean isPassordGyldig() {
		return passordGyldig;
	}
	/**
	 * @param passordGyldig the passordGyldig to set
	 */
	public void setPassordGyldig(boolean passordGyldig) {
		this.passordGyldig = passordGyldig;
	}
	/**
	 * @return the passordRepetert
	 */
	public boolean isPassordRepetert() {
		return passordRepetert;
	}
	/**
	 * @param passordRepetert the passordRepetert to set
	 */
	public void setPassordRepetert(boolean passordRepetert) {
		this.passordRepetert = passordRepetert;
	}
	
	
}
