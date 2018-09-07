package no.hvl.dat108.oppgave3;

import java.util.function.Function;

/**
 * 
 * @author Truls Martinsen
 *
 */
public class Ansatt {
	String fornavn;
	String etternavn;
	char kj�nn;
	String stilling;
	int aarslonn;
	
	
	/**
	 * @param fornavn
	 * @param etternavn
	 * @param kj�nn
	 * @param stilling
	 * @param aarslonn
	 */
	public Ansatt(String fornavn, String etternavn, char kj�nn, String stilling, int aarslonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kj�nn = kj�nn;
		this.stilling = stilling;
		this.aarslonn = aarslonn;
	}
	
	
	/**
	 * @param function<Integer, Integer> der f(gammell�nn) = nyl�nn
	 */
	public void endreL�nn(Function<Integer, Integer> func) {
		this.aarslonn = func.apply(aarslonn);
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
	 * @return the kj�nn
	 */
	public char getKj�nn() {
		return kj�nn;
	}
	/**
	 * @param kj�nn the kj�nn to set
	 */
	public void setKj�nn(char kj�nn) {
		this.kj�nn = kj�nn;
	}
	/**
	 * @return the stilling
	 */
	public String getStilling() {
		return stilling;
	}
	/**
	 * @param stilling the stilling to set
	 */
	public void setStilling(String stilling) {
		this.stilling = stilling;
	}
	/**
	 * @return the aarslonn
	 */
	public int getAarslonn() {
		return aarslonn;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ansatt [fornavn=" + fornavn + ", etternavn=" + etternavn + ", kj�nn=" + kj�nn + ", stilling=" + stilling
				+ ", aarslonn=" + aarslonn + "]";
	}


	/**
	 * @param aarslonn the aarslonn to set
	 */
	public void setAarslonn(int aarslonn) {
		this.aarslonn = aarslonn;
	}
	
	
}
