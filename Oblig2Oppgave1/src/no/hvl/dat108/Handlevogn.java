package no.hvl.dat108;

import java.util.ArrayList;

public class Handlevogn {
	private int id_counter = 0;
	private ArrayList<Vare> varer;
	
	Handlevogn() {
		varer = new ArrayList<Vare>();
	}
	
	void addVare(String txt) {
		varer.add(new Vare(txt, id_counter++));
	}
	
	void removeVare(int id) {
		for (int i = 0; i < varer.size(); i++) {
			if (varer.get(i).getId() == id) {
				varer.remove(i);
				return;
			}
		}
	}

	/**
	 * @return the varer
	 */
	public ArrayList<Vare> getVarer() {
		return varer;
	}

	/**
	 * @param varer the varer to set
	 */
	public void setVarer(ArrayList<Vare> varer) {
		this.varer = varer;
	}

	
}
