package multiThreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch01 {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(10);
		
		ThreadCreator1 thread1 = new ThreadCreator1(latch);
		ThreadCreator1 thread2 = new ThreadCreator1(latch);
		ThreadCreator1 thread3 = new ThreadCreator1(latch);
		ThreadCreator1 thread4 = new ThreadCreator1(latch);
		ThreadCreator1 thread5 = new ThreadCreator1(latch);
		ThreadCreator1 thread6 = new ThreadCreator1(latch);
		ThreadCreator1 thread7 = new ThreadCreator1(latch);
		ThreadCreator1 thread8 = new ThreadCreator1(latch);
		ThreadCreator1 thread9 = new ThreadCreator1(latch);
		ThreadCreator1 thread10 = new ThreadCreator1(latch);
		ThreadCreator1 thread11 = new ThreadCreator1(latch);
		ThreadCreator1 thread12 = new ThreadCreator1(latch);
		ThreadCreator1 thread13 = new ThreadCreator1(latch);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();
		thread11.start();
		thread12.start();
		thread13.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("all threads are done now");

	}

}
class ThreadCreator1 extends Thread{
	private CountDownLatch latch;

	public ThreadCreator1(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()
				+" starts running");
		System.out.println(Thread.currentThread().getName()
				+" stops running");
		
		System.out.println("============================");
		
		latch.countDown();
		
		
		
	}
	
}