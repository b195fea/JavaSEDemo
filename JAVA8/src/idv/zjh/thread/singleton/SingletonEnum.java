package idv.zjh.thread.singleton;

/**
 * 透過枚舉模式創建單例
 * @author zjh
 *
 */
public class SingletonEnum {
	//私有化構造方法
	private SingletonEnum() {}
		
	public SingletonEnum getInstance() {
		return Singleton.Instance.getInstance();
	}
	
	private enum Singleton{
		Instance;
		
		private SingletonEnum singletonEnum;
		
		//由JVM保證只會執行一次
		Singleton() {
			singletonEnum  = new SingletonEnum();
		}
		
		public SingletonEnum getInstance() {
			return singletonEnum;
		}
	}
}
