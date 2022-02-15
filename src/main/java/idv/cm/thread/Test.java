package idv.cm.thread;

import java.util.concurrent.*;

public class Test {

	public static void main(String[] args) {
//		Dog dog = new Dog();
//		Thread t1 = new Thread(dog);
//		Thread t2 = new Thread(dog);
//		t1.start();
//		t2.start();
//		
		System.out.println("======main thread : "+Thread.currentThread().getName()+"=======");
		
		Bird bird = new Bird();
		Thread b1 = new Thread(bird);
		Thread b2 = new Thread(bird);
		b1.start();
		b2.start();
		System.out.println("======THE END=========================");
	}

}
