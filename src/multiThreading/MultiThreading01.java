package multiThreading;

public class MultiThreading01 {

	public static void main(String[] args) throws InterruptedException {
		long startingTime1= System.currentTimeMillis();
		CountWithoutThread obj1 = new CountWithoutThread(1);
		obj1.countMe();
		System.out.println("=============");
		CountWithoutThread obj2 = new CountWithoutThread(2);
		obj2.countMe();
		
		long endingTime1 = System.currentTimeMillis();
		System.out.println("Duration of execution: "+(endingTime1-startingTime1));
		System.out.println("=============");
		long startingTime2 = System.currentTimeMillis();
		CountWithThread obj3 = new CountWithThread(3);
		obj3.start();
		CountWithThread obj4 = new CountWithThread(4);
		obj4.start();
		long endingTime2 = System.currentTimeMillis();
		System.out.println("Duration of execution: "+(endingTime2-startingTime2));
		

	}

}
class CountWithoutThread{
	
	private int threadNum;
	
	public CountWithoutThread(int threadNum) {
		this.threadNum = threadNum;
	}
	
	public void countMe() {
		for(int i=1; i<10;i++) {
			System.out.println("i:"+i+" thread num is "+threadNum);
		}
	}
}
class CountWithThread extends Thread {
	
	private int threadNum;
	
	public CountWithThread(int threadNum) {
		this.threadNum=threadNum;
		
	}
	
	public void countMe() throws InterruptedException {
		for(int i=1; i<10;i++) {
			Thread.sleep(500);
			System.out.println("i:"+i+" thread num is "+threadNum);
		}
	}
	@Override
	public void run() {
		try {
			countMe();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	
	
}
