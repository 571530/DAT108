package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String navn;
	private List<Kant> kanter;
	
	public Node(String navn) {
		this.navn = navn;
		kanter = new ArrayList<Kant>();
	}
	
	public void lagKantTil(Node n, int vekt) {
		kanter.add(new Kant(vekt, this, n));
	}
	
	public void fjernKant(Kant k) {
		kanter.remove(k);
	}
	
	/**
	 * @return the navn
	 */
	public String getNavn() {
		return navn;
	}
	/**
	 * @param navn the navn to set
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}
	/**
	 * @return the kanter
	 */
	public List<Kant> getKanter() {
		return kanter;
	}
	/**
	 * @param kanter the kanter to set
	 */
	public void setKanter(List<Kant> kanter) {
		this.kanter = kanter;
	}
}
