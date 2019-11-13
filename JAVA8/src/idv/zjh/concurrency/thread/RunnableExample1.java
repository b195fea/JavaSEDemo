package idv.zjh.concurrency.thread;

/**
 * 繼承Thread類，必須實作run方法，並使用strat方法啟動，我們可以看到三個線程同步執行，在這範例中，我們可以看到三個線程同步執行
 * @author zjh
 */
public class RunnableExample1 implements Runnable {
	
	private int i = 0;
	
	public void run() {
		for(;i < 100 ; i ++) {
			System.out.println(Thread.currentThread().getName() + ":" +  i);
		}
	}
	
	public static void main(String args[]) {
		Runnable runnable = new RunnableExample1(); 
		
		for (int i = 0 ; i < 100 ; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			if(i == 20) {
				new Thread(runnable,"thread 1").start();
				new Thread(runnable,"thread 2").start();
			}
		}
	}
}
