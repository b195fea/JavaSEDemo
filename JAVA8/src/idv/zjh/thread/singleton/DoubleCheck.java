package idv.zjh.thread.singleton;

public class DoubleCheck {
	private volatile static DoubleCheck object = null;
	
	public DoubleCheck build() {
		if(object == null) {
			synchronized (object) {
				if(object == null) {
					object = new DoubleCheck();
				}
			}
		}
		return object;
	}
}
