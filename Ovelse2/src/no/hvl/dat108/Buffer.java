package no.hvl.dat108;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * A shared buffer for consumers and producers. The item type is int. The buffer
 * is implemented by using a double ended queue.
 *
 * @author Atle Geitung
 * @version 17.05.2018 C++ version
 * @version 30.08.2018 Java version
 */
public class Buffer {

	private final static int SIZE = 10;
	private LinkedList<Integer> buffer = new LinkedList<Integer>();

	/**
	 * Add a new item to the buffer. If the buffer is full, wait.
	 *
	 * @param item
	 *            the new item
	 * @throws InterruptedException
	 */
	public void add(Integer item) {
		while (true) {
			if (buffer.size() >= SIZE) {
				System.out.println("Listen er full");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				synchronized (buffer) {
					buffer.add(item);
					notify();
				}
				return;
			}
		}
	}

	/**
	 * Remove next available item from the buffer. If the buffer is empty, wait.
	 *
	 * @return next item
	 */
	public Integer remove() {
		while (true) {

			if (buffer.size() == 0) {
				System.out.println("Listen er tom");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Integer back = buffer.removeFirst();
				notify();
				
				return back;
			}


		}
	}

}
