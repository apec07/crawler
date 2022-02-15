package idv.cm.thread;

public class Bird extends Animal implements Runnable {
	
	public Bird() {
		age=0;
		moveType="fly";
		isHunter=false;
	}

	@Override
	public synchronized void run() {
		System.out.println("Sync "+Thread.currentThread().getName());
		for(int i=0;i<10;i++) {
			eat();
			System.out.println("current thread : "+Thread.currentThread().getName());
			System.out.println("age : "+age);
		}
	}

	@Override
	public void eat() {
		this.age +=1;
	}

	@Override
	public void sleep() {
		this.age-=1;
	}

}
