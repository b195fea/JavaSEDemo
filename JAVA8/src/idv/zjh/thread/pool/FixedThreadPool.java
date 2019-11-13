package idv.zjh.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 創建一個可重用，具有固定數量的線程池
 * @author zjh
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		Runnable task = () -> {
			for(int i = 0 ;i<100;i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		};
		pool.submit(task);
		pool.submit(task);
		
		pool.shutdown();
	}
}

