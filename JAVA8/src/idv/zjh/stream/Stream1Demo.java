package idv.zjh.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * JAVA 8 Stream 介紹
 * 傳統運算方法以及Stream比較,列印陣列內容。
 * @author zjh
 */
public class Stream1Demo {
	
	public volatile static Map<String,String> map = null ;
	
	public Map<String,String> getMap() {
		if(map == null ) {
			synchronized (Stream1Demo.class) {
				if(map == null ) {
					map = new HashMap<>();
				}
			}
		}
		return map;
	}
	
	
	private int[] nums = {1,2,3,4,5,6,7,8,9,10};
	

	public static void main(String[] args) {
		//傳統計算方法
		Stream1Demo demo = new Stream1Demo();
		
//		demo.tradationRun();
		demo.demo1();
	}
	
	private void tradationRun() {
		for(int i :  nums) {
			System.out.println(i);
		}
	}
	
	private void StreamRun() {
		String[] strArr = {"1","2","3"};
		Arrays.stream(nums).forEach(s -> System.out.println(s));
		Arrays.stream(nums).forEach(System.out::println);
//		IntStream.of(nums).forEach(System.out::println);
//		Stream.of(strArr).forEach(System.out::println);
//		Stream.of(nums).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::println);
//		Stream.of(nums).flatMapToInt(s -> s.length).forEach(System.out::println);
//		Stream.of(nums).forEach(System.out::println);
//		Stream<int[]> StreamInt = Stream.of(nums);
//		StreamInt. .forEach(System.out::println);
//		IntStream.range(1, 11).boxed().collect(Collectors.toList()).forEach(System.out::println);
//		IntStream.range(1, 11).boxed().forEach(System.out::println);
//		IntStream StreamInt2 = IntStream.range(1, 11);
//		
//		List<Integer> list = IntStream.range(1, 100).boxed().collect(Collectors.toList());
//		System.out.println(list.stream().count());
	}

	/**
	 * 流的中間操作
	 */
	private static void demo1() {
		IntStream.range(3,4).forEach(System.out :: println);
		IntStream.rangeClosed(3,8).forEach(System.out :: println);
//		int result = IntStream.of(nums).sum();
//		System.out.println(result);
	}
	
	/**
	 * 流的終止操作
	 */
	private static void demo2() {
		String str = "my name is Terence";
		Consumer<String> printNewLine = System.out::println;
		printNewLine.accept("----------------------start---------------------");
		str.chars().parallel().forEach(S -> System.out.println((char)S));
		printNewLine.accept("----------------------end---------------------");
		printNewLine.accept("----------------------start---------------------");
		str.chars().parallel().forEachOrdered(S -> System.out.println((char)S));
		printNewLine.accept("----------------------end---------------------");
		printNewLine.accept("----------------------start---------------------");
		List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
		printNewLine.accept(list.toString());
		Optional<String> letters = Stream.of(str.split(" ")).reduce((s1,s2) -> s1 + "|" + s2);
		System.out.println(letters.orElse(""));
		Optional<String> letters2 = Stream.of(str.split(" ")).filter( s1 -> s1.length() >2).reduce((s1,s2) -> s1 + "|" + s2);
		System.out.println(letters2.orElse(""));
		Optional<Integer> letters3 = Stream.of(str.split(" ")).map( s -> s.length()).reduce((s1,s2) -> s1+ s2 );
		System.out.println(letters3);
//		Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed());
		OptionalInt findFirst = new Random().ints().findFirst();
		System.out.println(findFirst);
		
		Optional<Integer> findFirst2 = Stream.of(str.split(" ")).map( s -> s.length()).findFirst();
		System.out.println(findFirst2);
	}
	
}