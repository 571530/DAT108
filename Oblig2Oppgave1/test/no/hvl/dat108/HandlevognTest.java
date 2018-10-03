package no.hvl.dat108;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HandlevognTest {

	boolean likeVarer(ArrayList<Vare> v1, ArrayList<Vare> v2) {
		boolean lik = true;

		int i = 0;
		for (Vare v : v1) {
			if (!v.equals(v2.get(i))) {
				lik = false;
				break;
			}
			i++;
		}

		return lik;
	}

	@Test
	void handlevognSlettOgAdd() {
		ArrayList<Vare> resultat = new ArrayList<Vare>();

		Vare v0 = new Vare("vare0", 0);
		Vare v1 = new Vare("vare1", 1);
		Vare v2 = new Vare("vare2", 2);
		Vare v3 = new Vare("vare3", 3);
		Vare v4 = new Vare("vare4", 4);

		Handlevogn handlevogn = new Handlevogn();

		handlevogn.addVare("vare0");
		handlevogn.addVare("vare1");
		handlevogn.addVare("vare2");
		handlevogn.addVare("vare3");
		handlevogn.addVare("vare4");

		resultat.add(v1);
		resultat.add(v3);

		handlevogn.removeVare(0);
		handlevogn.removeVare(2);
		handlevogn.removeVare(4);

		assert (likeVarer(resultat, handlevogn.getVarer()));
	}

	@Test
	void handlevognSlettOgAddLikeNavn() {
		ArrayList<Vare> resultat = new ArrayList<Vare>();

		Vare v0 = new Vare("vare", 0);
		Vare v1 = new Vare("vare", 1);
		Vare v2 = new Vare("vare", 2);
		Vare v3 = new Vare("vare", 3);
		Vare v4 = new Vare("vare", 4);

		Handlevogn handlevogn = new Handlevogn();

		handlevogn.addVare("vare");
		handlevogn.addVare("vare");
		handlevogn.addVare("vare");
		handlevogn.addVare("vare");
		handlevogn.addVare("vare");

		resultat.add(v1);
		resultat.add(v3);

		handlevogn.removeVare(0);
		handlevogn.removeVare(2);
		handlevogn.removeVare(4);

		assert (likeVarer(resultat, handlevogn.getVarer()));
	}

	@Test
	void handlevognAdd() {
		int antall_varer = 1000;
		Handlevogn handlevogn = new Handlevogn();
		for (int i = 0; i < antall_varer; i++) {
			handlevogn.addVare("vare" + i);
		}

		assert (handlevogn.getVarer().size() == antall_varer);
	}

	/**
	 * Passa på at vi ikke får en expection hvis handlevognen er tom og vi sletter
	 */
	@Test
	void handlevognSlettFraTomHandlevogn() {
		Handlevogn handlevogn = new Handlevogn();
		handlevogn.removeVare(0);

		assert (true);
	}

	void handlevognSlettFeilId() {

		ArrayList<Vare> resultat = new ArrayList<Vare>();

		Vare v0 = new Vare("vare1", 0);
		Vare v1 = new Vare("vare2", 1);
		Vare v2 = new Vare("vare3", 2);

		Handlevogn handlevogn = new Handlevogn();

		handlevogn.addVare("vare");
		handlevogn.addVare("vare");
		handlevogn.addVare("vare");

		resultat.add(v0);
		resultat.add(v1);
		resultat.add(v2);

		handlevogn.removeVare(10);
		handlevogn.removeVare(-1);
		handlevogn.removeVare(9);

		assert (likeVarer(resultat, handlevogn.getVarer()));
	}

}
