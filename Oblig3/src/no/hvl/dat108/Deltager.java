package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(schema = "dat108oblig3", name = "deltager")
public class Deltager {
	private String fornavn;
	private String etternavn;
	private String kjonn;
	@Id
	private String mobil;
	private String pass;
	
	
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
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
	 * @return the fornavn
	 */
	public String getFornavn() {
		return fornavn;
	}
	
	public Deltager() {
		
	}
	
	/**
	 * @param fornavn
	 * @param etternavn
	 * @param kjonn
	 * @param mobil
	 * @param pass
	 */
	public Deltager(String fornavn, String etternavn, String kjonn, String mobil, String pass) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.mobil = mobil;
		this.pass = pass;
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
	
	
}
