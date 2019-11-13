package idv.zjh.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.BiFunction;
import java.util.function.Function;

interface Test1{
	void eat();
}

class Dog{
	private String name = "哮天犬";
	
	public static void bark(Dog dog) {
		System.out.println(dog + "叫了");
	}
	
	/**
	 * 默認10斤狗糧
	 */
	private int food = 10;
	
	/**
	 * 
	 * @param num
	 * @return
	 * 
	 * JDK 默認會把當前實例，傳入靜態方法，位置是第一個
	 */
	public int eat(Dog this,int num) {
		System.out.println("吃了".concat(String.valueOf(num)).concat("狗糧"));
		this.food -= num;
		return this.food;
	}
	
	public void test(final String eat1) {
		new Test1() {
			@Override
			public void eat() {
				System.out.println(eat1);
			}
		};
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}

/*
 * 方法引用一般有三种格式：
 * 
 * 1. 实例对象名::实例方法名 2. 类名::静态方法名 3. 类名::实例方法名
 */

/**
 * 方法引用說明：
 * （1）
 * @author zjh
 */
public class Lambda3MathodRefrece {
	public static void main(String[] args) {
		System.out.println("---基本範例---");
		Lambda3MathodRefrece.Basic();
		System.out.println("---靜態方法的方法引用---");
		Lambda3MathodRefrece.staticMathod();
		System.out.println("---實例方法的方法引用---");
		Lambda3MathodRefrece.NotStaticMathod();
		System.out.println("---使用類名的方法引用---");
		Lambda3MathodRefrece.classStaticMathod();
		
		
		System.out.println("---其他---");
		
	}

	/** 
	 *  函數的參數跟箭頭左邊一樣我們就可以使用方法引用
	 * 示範 (s) -> System.out.println(s); 可以簡寫成System.out::println;
	 */
	public static void Basic() {
		Consumer<String> consumerDemo1 = (s) -> System.out.println(s);
		consumerDemo1.accept("列印字串");
		Consumer<String> consumerDemo2 = System.out::println;
		consumerDemo2.accept("列印字串");
	}

	/**
	 * 成員方法的方法引用
	 */
	public static void staticMathod() {
		Consumer<Dog> consumerDemo1 = dog -> Dog.bark(dog);
		consumerDemo1.accept(new  Dog());
		Consumer<Dog> consumerDemo2 = Dog::bark;
		consumerDemo2.accept(new  Dog());
	}
	
	/**
	 * 實例方法的方法引用
	 * （宣告的時候以實例宣告）
	 */
	public static void NotStaticMathod() {
		Dog dog = new Dog();
		Function<Integer, Integer> function1 = dog::eat;
		System.out.println("還剩下".concat(String.valueOf(function1.apply(2)).concat("斤")));
		//使用方法引用的時候，是傳值，所以後面把dog設為null，並沒有影響。
		dog = null;
		System.out.println("還剩下".concat(String.valueOf(function1.apply(2)).concat("斤")));
		
		
		//lambda 則是傳參數，所以必須保證參數不會變化。
		final Dog dog2 = new Dog();
		Function<Integer, Integer> function2 = num1 -> dog2.eat(num1);
		System.out.println("還剩下".concat(String.valueOf(function2.apply(2)).concat("斤")));
		

	}
	
	/**
	 * 實例方法 用類名類方法引用
	 * （實際上就是呼叫的時候傳入實例）
	 */
	public static void classStaticMathod() {
		BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
		System.out.println("還剩下".concat(String.valueOf(eatFunction.apply(new Dog(),2)).concat("斤")));
	}


}
