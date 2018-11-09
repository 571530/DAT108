package no.hvl.dat108;

public class Main {
	public static void main(String[] args) {
		Graf graf = new Graf();
		
		
		Node n1 = new Node("n1");
		Node n2 = new Node("n2");
		Node n3 = new Node("n3");
		Node n4 = new Node("n4");
		Node n5 = new Node("n5");
		Node n6 = new Node("n6");
		Node n7 = new Node("n7");
		
		
		graf.nyNode(n1);
		graf.nyNode(n2);
		graf.nyNode(n3);
		graf.nyNode(n4);
		graf.nyNode(n5);
		graf.nyNode(n6);
		
		graf.nyKant(n1, n2, 1, true);
		graf.nyKant(n1, n3, 10, true);
		graf.nyKant(n2, n4, 5, true);
		graf.nyKant(n3, n4, 1, true);
		graf.nyKant(n3, n5, 3, true);
		graf.nyKant(n4, n6, 4, true);
		graf.nyKant(n5, n6, 2, true);
		
		
		
		for (Node n : graf.breddeForst(n1)) {
			System.out.println(n.getNavn());
		}
		
		for (Kant k : graf.prims()) {
			System.out.println(k.getStart().getNavn() + ", " + k.getSlutt().getNavn());
		}
	}
}
