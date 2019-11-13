package idv.zjh.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 創建一個具有可緩存功能的線程池
 * @author zjh
 */
public class CachedThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) { 
            final int index = i;
            executorService.execute(() -> {
            	System.out.println(index);
            });
        }
        executorService.shutdown();
	}
}
