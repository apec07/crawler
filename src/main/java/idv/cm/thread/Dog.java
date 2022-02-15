package idv.cm.thread;

public class Dog extends Animal implements Runnable {
	
	
	public Dog() {
		age=0;
		moveType="walk";
		isHunter=true;
	}

	@Override
	public void run() {
		System.out.println("Async "+Thread.currentThread().getName());
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
