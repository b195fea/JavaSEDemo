package idv.zjh.lambda;

import java.util.function.Function;

/**
 * 柯里化 與 聯級表達式
 * @author zjh
 *
 */
public class Lambda4Currying {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lambda4Currying.demo1();
	}
	
	
	/**
	 * 聯級表達式示範
	 *  這是聯級表達式 ：	a -> b -> c -> a + b + c
	 *  這是科里化	：		add.apply(10).apply(5).apply(6)
	 */
	private static void demo1() {
		Function<Integer, Function<Integer,Function<Integer,Integer>>> add = a -> b -> c -> a + b + c;
		int result = add.apply(10).apply(5).apply(6);
		System.out.println(result);
	} 
	

}
