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

public class Stream2Create {
	public static void main(String[] args) {
		Stream2Create create = new Stream2Create();
		create.rangeCreate();
	}

	/**
	 * 利用Collection創造Stream
	 * 
	 * @see Set
	 * @see List
	 * @see Map
	 * @see SortedSet
	 * @see SortedMap
	 * @see HashSet
	 * @see TreeSet
	 * @see ArrayList
	 * @see LinkedList
	 * @see Vector
	 * @see Collections
	 * @see Arrays
	 * @see AbstractCollection
	 */
	private void collectionCreate() {
		Collection colleaction = new HashSet<>();
		Stream stream = colleaction.stream();
	}

	/**
	 * 陣列宣告Stream
	 */
	private void ArrayCreate() {
		//字串陣列
		String[] strArraay = {"1","2","3"};
		Stream stream  = Stream.of(strArraay);
		stream = Arrays.stream(strArraay);
		
		int[] intArray = {1,2,3};
		IntStream intStream = IntStream.of(intArray);
		intStream = Arrays.stream(intArray);
		intStream = Stream.of(intArray).flatMapToInt(s -> Arrays.stream(s));
		
		long[] longArray = {1,2,3};
		LongStream longStream = LongStream.of(longArray);
		longStream = Arrays.stream(longArray);
		longStream = Stream.of(longArray).flatMapToLong(s -> Arrays.stream(s));
		
		double[] doubleArray = {1,2,3};
		DoubleStream doubleStream = DoubleStream.of(doubleArray);
		doubleStream = Arrays.stream(doubleArray);
		doubleStream = Stream.of(doubleArray).flatMapToDouble(s -> Arrays.stream(s));
	}
	
	/**
	 * 取得區間
	 */
	private void rangeCreate() {
		IntStream.range(3,8).forEach(System.out :: println);				//列印3~7
		IntStream.rangeClosed(3,8).forEach(System.out :: println);		//列印3~8
	}
	
	/**
	 * 產生亂數
	 */
	private void randomCreate() {
		IntStream intStream = new Random().ints().limit(10);
		intStream.forEach(System.out :: println);
	}
	
}
