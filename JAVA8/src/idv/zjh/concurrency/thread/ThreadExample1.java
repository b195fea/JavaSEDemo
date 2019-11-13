package idv.zjh.concurrency.thread;

/**
 * 繼承Thread類，必須實作run方法，並使用strat方法啟動，我們可以看到三個線程同步執行，在這範例中，我們可以看到三個線程同步執行
 * @author zjh
 */
public class ThreadExample1 extends Thread {
	
	private int i = 0;
	
	public void run() {
		for(;i < 100 ; i ++) {
			System.out.println(super.getName() + ":" +  i);
		}
	}
	
	public static void main(String args[]) {
		for (int i = 0 ; i < 100 ; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			if(i == 20) {
				new ThreadExample1().start();
				new ThreadExample1().start();
			}
		}
	}
}
