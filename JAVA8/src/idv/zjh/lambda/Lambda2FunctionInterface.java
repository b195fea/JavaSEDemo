package idv.zjh.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 介紹各類型的函數接口
 * @author zjh
 */
public class Lambda2FunctionInterface {
	public static void main(String[] args) {
		//Predicate<T>——接收 T并返回 boolean
		Lambda2FunctionInterface.Predicate();
		Lambda2FunctionInterface.Consumer();
		Lambda2FunctionInterface.Function();
		Lambda2FunctionInterface.Supplier();
		Lambda2FunctionInterface.UnaryOperator();
		Lambda2FunctionInterface.BinaryOperator();
		Lambda2FunctionInterface.BiFunction();
		
	}

	/**
	 * Predicate 傳入一個參數， 返回Boolean函數
	 */
	public static void Predicate() {
		Predicate<String> demo = (s) -> "S".equals(s);
		System.out.println(demo.test("S2"));
	}

	/**
	 * Consumer<String> 接收一個參數 String 不返回資料
	 */
	public static void Consumer() {
		// 接收參數不回傳
		Consumer<String> consumerDemo = (s) -> System.out.println("Consumer:" + s);
		consumerDemo.accept("123");

		// 接收整數參數
		IntConsumer intConsumerDemo = (i) -> System.out.println(i * i);
		intConsumerDemo.accept(10);

		// 方法引用
//		Consumer<String> consumerMethodDemo = System.out::println;
//		consumerMethodDemo.accept("456");
	}

	/**
	 * Function<Integer, String> 
	 * 接收一個參數 <Integer> 返回一個參數 <String>
	 */
	public static void Function() {
		Function<Integer, String> powFunc = (i) -> i + "的" + i + "次方：" + Math.pow(i, i);
		System.out.println(powFunc.apply(5));
	}

	/**
	 * Supplier<String> 
	 * 不接受參數 返回一個參數 <String>
	 */
	public static void Supplier() {
		Supplier<String> supplier = () -> "supplier";
		System.out.println("this is " + supplier.get());
	}

	/**
	 * UnaryOperator<String> 
	 * 接收一個參數 <String> 返回一個參數 <String>
	 */
	public static void UnaryOperator() {
		UnaryOperator<String> unaryOperator = (s) -> "I am" + s;
		System.out.println("this is " + unaryOperator.apply("Terence"));
	}

	/**
	 * BinaryOperator<Integer>
	 * 接收兩個參數<Integer> ，返回一個參數<Integer>
	 */
	public static void BinaryOperator() {
		BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 + num2;
		System.out.println("sum:" + binaryOperator.apply(6, 11));
	}

	/**
	 * BiFunction<String, Integer, String>
	 * 接收兩個參數<String, Integer> ，返回一個參數<String>
	 */
	public static void BiFunction() {
		BiFunction<String, Integer, String> biFunction = (word, price) -> word + ":" + price;
		System.out.println(biFunction.apply("蘋果的價格", 100));
	}
}
