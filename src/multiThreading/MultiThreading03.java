package multiThreading;

public class MultiThreading03 {

	public static void main(String[] args) {
		
		Brackets obj1 = new Brackets();
		Brackets obj2= new Brackets();
		
		Thread th1= new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=1; i<=7; i++) {
					obj1.generateBrackets();
				}
				
			}
			
		});
		th1.start();
		try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=1; i<=7; i++) {
					obj2.generateBrackets();
				}
				
			}
			
		});
		th2.start();
		
	}

}

class Brackets{
	synchronized public void generateBrackets(){
		for(int i=1; i<10; i++) {
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
		}
		System.out.println();
	}
}
