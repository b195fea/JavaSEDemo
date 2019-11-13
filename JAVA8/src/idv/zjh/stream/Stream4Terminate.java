package idv.zjh.stream;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Stream4Terminate {
	private int[] intArray = {1,2,3,4,5,6,8,9,1,22,33,55,66};
	private Integer[] integerArray = {1,2,3,4,5,6,8,9,1,22,33,55,66};
	private Character[] charArray = {1,2,3,4,5,6,8,9,1,22,33,55,66};
	private String[] StringArray = {"cat","dog","Monkey","bird","animal"};
	
	
	public static void main(String[] args) {
		Stream4Terminate demo = new Stream4Terminate();
		demo.reduce();
	}
	
	
	public void forEach() {
		IntStream.of(intArray).filter(i -> i <10).forEach(System.out::println);
	}
	
	/**
	 * 都是返回第一個值
	 */
	public void find() {
		int value = IntStream.of(intArray).parallel().findFirst().getAsInt();
		System.out.println(value);
		//並行流上有差別。
		value = IntStream.of(intArray).parallel().findAny().getAsInt();
		System.out.println(value);
	}
	
	public void match() {
		//anyMatch 只要有一個符合就返回True
		boolean value = IntStream.of(intArray).anyMatch(num -> num < 10);
		System.out.println(value);
		//anyMatch 全部符合cai返回True
		value = IntStream.of(intArray).allMatch(num -> num < 10);
		System.out.println(value);
		//noneMatch 所有元素都不符合返回True
		value = IntStream.of(intArray).noneMatch(num -> num < 10);
		System.out.println(value);
	}
	
	public void basicOperator() {
		int value = IntStream.of(intArray).min().getAsInt();
		System.out.println(value);
		value = IntStream.of(intArray).max().getAsInt();
		System.out.println(value);
		value = (int) IntStream.of(intArray).count();
		System.out.println(value);
	}
	
	public void collect(){
		//<R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
		//1.Supplier 不接收參數，返回一個參數			    返回ArrayList
		//2.BiConsumer 接收一個參數，不返回資料		接收Stream的資料
		//3.BiConsumer 接收一個參數，不返回資料		接收2的結果，然後加到1的返回參數中
		ArrayList<Integer> intList = IntStream.of(intArray).map(i -> ++i).collect(ArrayList::new, List::add, List::addAll);
		Stream.of(intList).forEach(System.out::println);
		List<Integer> intList2 = Stream.of(integerArray).filter(p -> p > 2).collect(Collectors.toList());
//		List<People> people = new ArrayList<>();
//		Map<String, Integer> result = people.collect(HashMap::new,(map,p)->map.put(p.name,p.age),Map::putAll);
//		Map<String, Integer> result = people.collect(Collectors.toMap(p -> p.name, p -> p.age, (exsit, newv) -> newv));
	}
	
	
	public void toArray(){
		//<R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
		//1.Supplier 不接收參數，返回一個參數			返回ArrayList
		//2.BiConsumer 接收一個參數，不返回資料		接收Stream的資料
		//3.BiConsumer 接收一個參數，不返回資料		接收2的結果，然後加到1的返回參數中
		int[] intList = IntStream.of(intArray).map(i -> ++i).toArray();
//		Map<String, Integer> result = people.collect(HashMap::new,(map,p)->map.put(p.name,p.age),Map::putAll);
//		Map<String, Integer> result = people.collect(Collectors.toMap(p -> p.name, p -> p.age, (exsit, newv) -> newv));
	}
	
	
	public void reduce() {
//		int[] array = {23,43,56,97,32};
//  	  	Arrays.stream(array).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
//		int value = Stream.of(integerArray).reduce(0,(sum, item) -> sum + item);
//		System.out.println(value);
//		value = IntStream.of(intArray).filter(i -> i <10).peek(System.out::println).reduce(5, (i,i2) -> i+i2);
//		Arrays.stream(integerArray).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
//		System.out.println(value);
		OptionalInt intValue = IntStream.of(intArray).reduce((i,i2) -> i+i2);
		System.out.println(intValue.getAsInt());
	}
	
}
