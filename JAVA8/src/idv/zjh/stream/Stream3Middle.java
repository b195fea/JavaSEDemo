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
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Stream3Middle {
	private int[] intArray = {1,2,3,4,5,6,8,9,1,22,33,55,66};
	private Integer[] integerArray = {1,2,3,4,5,6,8,9,1,22,33,55,66};
	private Character[] charArray = {1,2,3,4,5,6,8,9,1,22,33,55,66};
	private String[] StringArray = {"cat","dog","Monkey","bird","animal"};
	
	
	public static void main(String[] args) {
		Stream3Middle demo = new Stream3Middle();
		demo.flatmap();
	}
	
	/**
	 * map對中間每一個元素做操作
	 */
	public void map(){
		//IntStream 必須傳入基本數組
		IntStream.of(intArray).map(i -> ++i).forEach(System.out::println);
		//Stream 則必須傳類別
		Stream.of(integerArray).mapToInt(data -> ++data).forEach(System.out::println);
	}
	
	public void distinct() {
		IntStream.of(intArray).distinct().forEach(System.out::println);
	}
	
	public void filter() {
		IntStream.of(intArray).filter(i -> i <10).forEach(System.out::println);
	}

	public void peek() {
		long count = IntStream.of(intArray).peek(System.out::println).count();
		System.out.println(count);
	}
	public void sorted() {
		IntStream.of(intArray).sorted().forEach(System.out::println);
	}
	
	public void limit() {
		IntStream.of(intArray).limit(5).forEach(System.out::println);
	}
	
	public void flatmap() {
		//從Stream<String> 轉變成 Stream<Integer>
		Stream.of(StringArray).flatMap(s -> s.chars().boxed()).forEach(System.out::println);
	}
	
}
