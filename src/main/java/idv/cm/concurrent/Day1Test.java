package idv.cm.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class Day1Test {

//	public static void main(String[] args) throws Exception {
//		NestClass cl1 = new NestClass();
//		cl1.test0();
//		cl1.test1();
//		
//	}

}

class NestClass {
	
	//first test
	@Test
	public void test0() throws Exception {
		  System.out.println("main函式開始執行0");
		  Thread thread=new Thread(new Runnable() {
		    @Override
		    public void run() {
		      System.out.println("===task start===");
		      try {
		        Thread.sleep(5000);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		      System.out.println("===task finish===");
		    }
		  });

		  thread.start();
		  System.out.println("main函式執行結束");

		}
@Test
	public void test1() throws Exception {

	    System.out.println("main函式開始執行1");

	    ExecutorService executor = Executors.newFixedThreadPool(1);
	    Future<Integer> future = executor.submit(new Callable<Integer>() {
	        @Override
	        public Integer call() throws Exception {

	            System.out.println("===task start===");
	            Thread.sleep(5000);
	            System.out.println("===task finish===");
	            return 3;
	        }
	    });
	    //這裡需要返回值時會阻塞主執行緒，如果不需要返回值使用是OK的。倒也還能接收
//	    Integer result=future.get();
	    System.out.println("main函式執行結束");

	    System.in.read();

	}
	
}
