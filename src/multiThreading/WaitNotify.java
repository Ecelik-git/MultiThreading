package multiThreading;

public class WaitNotify {
public static double balance=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaitNotify obj1=new WaitNotify();
		
		Thread thread1=new Thread(new Runnable(){
			@Override
			public void run() {
				
			obj1.withDraw(4000);
			}
			
			
			
		});
		thread1.start();
		
		
		
		Thread thread2=new Thread(new Runnable() {
			@Override
			public void run() {
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				obj1.deposit(10000);
				
			}
			
			
			
			
			
		});
		thread2.start();
		
			
	}
	
	
	
	public void withDraw(double amount) {
		
		synchronized(this) {
		if(balance<=0 || balance<amount) {
			
			try {
				System.out.println("waiting for updating balance");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		balance=balance-amount;
		System.out.println("withdraw is successful balance is updated "+balance);
		
		
	}
	
	
	public void deposit(double amount) {
		
		
		balance=balance+amount;
		System.out.println("balance is updated current blance is "+balance);
		
		synchronized(this) {
		notify();
		}
	}
}
