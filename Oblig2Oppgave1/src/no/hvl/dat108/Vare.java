package no.hvl.dat108;

public class Vare {
	private String tekst;
	private int id;
	
	/**
	 * @return the tekst
	 */
	public String getTekst() {
		return tekst;
	}
	/**
	 * @param tekst the tekst to set
	 */
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param tekst
	 * @param id
	 */
	public Vare(String tekst, int id) {
		super();
		this.tekst = tekst;
		this.id = id;
	}
	
	/**
	 * 
	 * @param v
	 * @return
	 */
	public boolean equals(Vare v) {
		return v.getId() == id && v.getTekst().equals(tekst);
	}
}
