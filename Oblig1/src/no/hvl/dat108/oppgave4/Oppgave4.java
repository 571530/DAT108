/**
 * 
 */
package no.hvl.dat108.oppgave4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import no.hvl.dat108.oppgave3.Ansatt;

import static java.util.stream.Collectors.toList;
/**
 * @author Truls Martinsen
 *
 */
public class Oppgave4 {

	/**
	 * 
	 * @param prosent
	 * @return en funksjon som øker tallet med prosenten gitt
	 */
	public static Function<Integer, Integer> prosentTillegg(int prosent) {
		return a -> ((a * (100+ prosent)) / 100);
	}
	
	/**
	 * @param args (ikke i bruk)
	 */
	public static void main(String[] args) {
		

		List<Ansatt> liste = Arrays.asList(
			new Ansatt("Test1", "Testesen", 'M', "Stilling1", 1000000),
			new Ansatt("Test2", "McTest", 'K', "Stilling2", 1000),
			new Ansatt("Test3", "Testeson", 'M', "Stilling3", 1000),
			new Ansatt("Test4", "Teste", 'K', "Sjef", 2000),
			new Ansatt("Test5", "Testn", 'M', "Sjef", 10000),
			new Ansatt("Test6", "McTesty", 'M', "Gartner", 2000)
		);
		
		// OPPGAVE A
		List<String> etternavnListe = liste.stream().map(a -> a.getEtternavn()).collect(toList());
		etternavnListe.stream().forEach(a -> System.out.println(a));
		
		//OPPGAVE B
		long antallKvinner = liste.stream().filter(a -> a.getKjønn() == 'K').count();
		System.out.printf("\nAntall kvinner %d", antallKvinner);
		
		//OPPGAVE C
		int gjennomsnittlonnForKvinner = (int) liste
				.stream()
				.filter(p -> p.getKjønn() == 'K')
				.mapToInt(Ansatt::getAarslonn)
				.average().getAsDouble();
		System.out.printf("\nGjennomsnittslønn for kvinner %d\n", gjennomsnittlonnForKvinner);
		
		
		// OPPGAVE D
		liste.stream()
				.filter(a -> a.getStilling() == "Sjef")
				.forEach(a -> a.endreLønn(prosentTillegg(7)));
		System.out.println("Liste etter sjefer går opp i lønn");
		liste.stream().forEach(a -> System.out.println(a));
		
		// OPPGAVE E
		boolean merEnn800k = liste.stream()
				.filter(a -> a.getAarslonn() > 800000)
				.count() > 0;
		System.out.printf("\nEr det noen som tjener mer enn 800000kr? %b\n", merEnn800k);
			
		// OPPGAVE F
		liste.stream().forEach(a -> System.out.println(a));
	
		// OPPGAVE G
		int lavesteLonn = liste.stream().min((a, b) -> a.getAarslonn() - b.getAarslonn()).get().getAarslonn();
		System.out.println("Ansatte med minste lønn");
		liste.stream().filter(a -> a.getAarslonn() == lavesteLonn).forEach(System.out::println);
		
		// OPPGAVE H
		int sum = IntStream.range(1, 1000).filter(x -> x % 3 == 0 || x % 5 == 0).sum();
		System.out.printf("\nSummen av heltall i [1, 1000> som er delelig på 5 og 3 er: %d", sum);
		
	}

}
