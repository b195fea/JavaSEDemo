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

public class Stream5parallel {
	
	public static void main(String[] args) {
		Stream5parallel demo = new Stream5parallel();
		demo.forEach();
	}
	
	
	public void forEach() {
		IntStream.range(1,10).parallel().forEach(System.out::println);
		System.out.println("------------");
		IntStream.range(1,10).parallel().forEachOrdered(System.out::println);
	}
}
