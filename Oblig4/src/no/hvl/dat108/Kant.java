package no.hvl.dat108;

public class Kant {
	private int vekt;
	private Node start;
	private Node slutt;
	
	/**
	 * @param vekt
	 * @param start
	 * @param slutt
	 */
	public Kant(int vekt, Node start, Node slutt) {
		this.vekt = vekt;
		this.start = start;
		this.slutt = slutt;
	}
	
	/**
	 * @return the vekt
	 */
	public int getVekt() {
		return vekt;
	}
	/**
	 * @param vekt the vekt to set
	 */
	public void setVekt(int vekt) {
		this.vekt = vekt;
	}
	/**
	 * @return the start
	 */
	public Node getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(Node start) {
		this.start = start;
	}
	/**
	 * @return the slutt
	 */
	public Node getSlutt() {
		return slutt;
	}
	/**
	 * @param slutt the slutt to set
	 */
	public void setSlutt(Node slutt) {
		this.slutt = slutt;
	}
}
