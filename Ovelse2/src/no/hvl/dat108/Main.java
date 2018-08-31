package no.hvl.dat108;

public class Main {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		
		Producer producer1 = new Producer(buffer);
		Producer producer2 = new Producer(buffer);
		Producer producer3 = new Producer(buffer);
		Consumer consumer1 = new Consumer(buffer);
		Consumer consumer2 = new Consumer(buffer);
		Consumer consumer3 = new Consumer(buffer);
		
		producer1.start();
		//producer2.start();
		//producer3.start();
		consumer1.start();
		//consumer2.start();
		//consumer3.start();
	}
}
