package multiThreading;

public class MultiThreading05 {

	public static void main(String[] args) {
		Brackets03 obj1=new Brackets03();
		Brackets03 obj2=new Brackets03();
		
		Thread th1=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=1;i<=5;i++) {
				obj1.generateBrackets03("thread1");
				}
			}
			
			
		});
		th1.start();
//		try {
//			th1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Thread th2=new Thread(new Runnable() {
			@Override
			public void run() {
				
				for(int i=1;i<=5;i++) {
				obj2.generateBrackets03("thread2");
				}
			}
			
			
		});
		
		th2.start();
		
		{
			
			
		}
		
		
		
	}
}
class Brackets03{
	
	
	//synchronized can not work with different object
	//so for fifferent object we can use synchronized static
	//synchronized static can work with different object
	//if you don't put paramter thread can think they are same method even you can use
	// different object sametimes thread can accept as same object so for that you can use paramater
	// for the methods
	synchronized static public void generateBrackets03(String numOfThread) {
		
		for(int i=1;i<=10;i++) {
			
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
			
			
		}
	
	System.out.println();

	}

}
