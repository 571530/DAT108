package no.hvl.dat108.oppgave3;

import java.util.function.Function;

/**
 * 
 * @author Truls Martinsen
 *
 */
public class Oppgave3 {
	/**
	 * 
	 * @param tillegg
	 * @return en funksjon som øker tallet med i
	 */
	public static Function<Integer, Integer> fastKroneTillegg(int tillegg) {
		return a -> a + tillegg;
	}
	
	/**
	 * 
	 * @param prosent
	 * @return en funksjon som øker tallet med prosenten gitt
	 */
	public static Function<Integer, Integer> prosentTillegg(int prosent) {
		return a -> ((a * (100 + prosent)) / 100);
	}
	
	/**
	 * 
	 * @param tillegg
	 * @param lavlonn
	 * @return en funksjon gjør fastKroneTillegg hvis lønnen er mindre eller lik lavlønn
	 */
	public static Function<Integer, Integer> fastKroneTilleggHvisLavLonn(int tillegg, int lavlonn) {
		return a -> {
			if (a <= lavlonn)
				return fastKroneTillegg(tillegg).apply(a);
			return a;
		};
	}
	
	/**
	 * @param args (ikke i bruk)
	 */
	public static void main(String[] args) {
		
		Ansatt a1 = new Ansatt("Test1", "Testesen", 'M', "Stilling1", 1000);
		Ansatt a2 = new Ansatt("Test2", "McTest", 'K', "Stilling2", 1000);
		Ansatt a3 = new Ansatt("Test3", "Testeson", 'M', "Stilling3", 1000);
		
		System.out.printf("Ansatt1 før endring med fastKroneTillegg(100): %d\n\n", a1.getAarslonn());
		a1.endreLønn(fastKroneTillegg(100));
		System.out.printf("Ansatt1 etter endring med fastKroneTillegg(100): %d\n\n", a1.getAarslonn());	
		
		System.out.printf("Ansatt2 før endring med prosentTillegg(20): %d\n\n", a2.getAarslonn());
		a2.endreLønn(prosentTillegg(20));
		System.out.printf("Ansatt2 etter endring med prosentTillegg(20): %d\n\n", a2.getAarslonn());	
		
		System.out.printf("Ansatt3 før endring med fastKroneTilleggHvisLavlonn(200, 800): %d\n", a3.getAarslonn());
		a3.endreLønn(fastKroneTilleggHvisLavLonn(200, 800));
		System.out.printf("Ansatt3 etter endring med fastKroneTilleggHvisLavlonn(200, 800): %d\n\n", a3.getAarslonn());	
		
		System.out.printf("Ansatt3 før endring med fastKRoneTilleggHvisLavLønn(200, 1100): %d\n", a3.getAarslonn());
		a3.endreLønn(fastKroneTilleggHvisLavLonn(200, 1100));
		System.out.printf("Ansatt3 etter endring med fastKroneTilleggHvisLavlonn(200, 1100): %d\n\n", a3.getAarslonn());	
		
		
	}
}
