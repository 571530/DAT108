package no.hvl.dat108.oppgave2;

public class Main {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		
		Producer producer1 = new Producer(buffer);
		Consumer consumer1 = new Consumer(buffer);
		
		producer1.start();
		consumer1.start();
	
		/*
		Oppgave D
		System.out.println er synchronized fra før av,
		hvis ikke den var det ville det vært lurt å synkronisere den også
		
		Kode til println source: http://hg.openjdk.java.net/jdk6/jdk6/jdk/file/39e8fe7a0af1/src/share/classes/java/io/PrintStream.java	
		public void println(String x) {
    		synchronized (this) {
        		print(x);
        		newLine();
    		}
		}
		 
		*/
	}
}
