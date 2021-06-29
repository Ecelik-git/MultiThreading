package multiThreading;

public class MultiThreading04 {

	public static void main(String[] args) {
Brackets02 obj1=new Brackets02();
		
		Thread th1=new Thread(new Runnable() {
			@Override
			public void run() {
				
				long time1=System.currentTimeMillis();
				for(int i=1;i<=5;i++) {
				obj1.generateBrackets02();
				}
				long time2=System.currentTimeMillis();
				System.out.println("first thread complated "+(time2-time1));
			}
			
			
		});
		th1.start();
		
		Thread th2=new Thread(new Runnable() {
			@Override
			public void run() {
				long time3=System.currentTimeMillis();
				for(int i=1;i<=5;i++) {
				obj1.generateBrackets02();
				}
				long time4=System.currentTimeMillis();
				System.out.println("second thread is complated "+(time4-time3));
			}
			
			
		});
		
		th2.start();
		
		
		
	}
}
class Brackets02{
	
	//if you don't need to us synchronized during to all method use synchronized(this)
	//synchronized (this) just working part of method so it's mean you break the threads for sort time
	//it's mean you application ll be fast
 public void generateBrackets02() {
		
		synchronized(this) {
		for(int i=1;i<=10;i++) {
			
			if(i<=5) {
				System.out.print("[");
			}else {
				
				System.out.print("]");
			}
			
		
		}
		System.out.println();
		}
		
	for(int i=1;i<=10;i++) {
		
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	}

}
