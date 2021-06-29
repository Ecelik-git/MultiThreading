package multiThreading;

public class MultiThreading02 {
	public static int count;

	public static void main(String[] args) throws InterruptedException {

		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Counter.count();
				System.out.println("first thread");

			}

		});

		th1.start();

		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {

				Counter.count();
				System.out.println("second  thread");
			}

		});

		th2.start();
		try {
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("last value of count variable:" + MultiThreading02.count++);
	}
}

class Counter {

	synchronized public static void count() {

		for (int i = 1; i <= 1000; i++) {

			MultiThreading02.count++;

		}

		// System.out.println("last value of count variable:"+MultiThreading02.count++);
	}

}
