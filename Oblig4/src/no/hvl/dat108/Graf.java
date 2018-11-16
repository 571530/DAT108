package no.hvl.dat108;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Graf {
	private List<Node> noder;

	public Graf() {
		noder = new ArrayList<Node>();
	}
	
	/**
	 * Gjør prims algoritme på grafen for å finne MST
	 * @return en liste med alle kantene i MST'et
	 */
	public List<Kant> prims() { 
		List<Kant> kanter = new ArrayList<Kant>();
		
		if (noder.isEmpty()) // Hvis tom graf stopp her
			return kanter;
		
		PriorityQueue<Kant> haug = new PriorityQueue<Kant>((x,y) -> Integer.compare(x.getVekt(), y.getVekt()));
		List<Node> noderBrukt = new ArrayList<Node>();
		
		Node start = noder.get(0);
		
		haug.addAll(start.getKanter());
		noderBrukt.add(start);
		
		while(!haug.isEmpty()) {
			Kant k = haug.remove();
			
			boolean startBrukt = noderBrukt.contains(k.getStart());
			boolean sluttBrukt = noderBrukt.contains(k.getSlutt());
			
			if (!startBrukt || !sluttBrukt) {
				Node n = !startBrukt ? k.getStart() : k.getSlutt();
				haug.addAll(n.getKanter());
				noderBrukt.add(n);
				kanter.add(k);
			}
		}
		
		return kanter;
	}
	
	/**
	 * Gjør et bredde først søk
	 * @param start
	 * @return en liste med alle noder som ble besøkt i rekkefølgen de ble besøkt
	 */
	public List<Node> breddeForst(Node start) {
		ArrayList<Node> noder = new ArrayList<Node>();
		
		ArrayList<Node> ubesokteNoder = new ArrayList<Node>();
		
		ubesokteNoder.add(start);
		
		while (!ubesokteNoder.isEmpty()) {
			Node node = ubesokteNoder.get(0);
			ubesokteNoder.remove(0);
			if (!noder.contains(node)) {
				ubesokteNoder.addAll(node.getKanter().stream()
						.map(x -> x.getSlutt())
						.collect(Collectors.toList()));
				noder.add(node);
			}
		}
		
		return noder;
	}
	
	public void nyNode(Node n) {
		noder.add(n);
	}
	
	/**
	 * Fjerner noden og alle kanter som slutter i noden.
	 * @param node
	 */
	public void fjernNode(Node node) {
		noder.remove(node); 
		noder.stream().forEach(n -> n.getKanter().removeIf(k -> k.getSlutt().equals(node)));
	}
	
	public void nyKant(Node node1, Node node2, int vekt, boolean beggeVeier) {
		if (noder.contains(node1) && noder.contains(node2)) {
			node1.lagKantTil(node2, vekt);
			if (beggeVeier) {
				node2.lagKantTil(node1, vekt);
			}
		}
	}
	
	
	public void fjernKant(Kant k) {
		k.getStart().fjernKant(k);
	}
	
	public List<Node> getNoder() {
		return noder;
	}

	public void setNoder(List<Node> noder) {
		this.noder = noder;
	}
}
