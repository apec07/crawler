package idv.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Tester4 {

	public static void main(String[] args) {
		
		//my example
		List<Object> list = Arrays.asList("a","b",2,21);
		System.out.println(list);
		List<Object> newList = list.stream().filter(i->i instanceof Number).collect(Collectors.toList());
		System.out.println(newList);
		
		Integer[] coins = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};     
		randomZero(coins, () -> (int) (Math.random() * 10));
		Arrays.asList(coins).forEach(System.out::println);
		System.out.println("Test");
		// Never done but not crash --> won't out of memory !!
		/*
		 * 使用Stream的原因是可以像個清單似地操作，而實際上在forEach()真正消耗某個數字之前，
		 * 並不會真正去呼叫nextDecimalNumberOfPI()，消耗掉的數字也不會被保留，因而不會耗費記憶體，
		 * 因而可以實現無限長度清單的概念。
		 */
		Stream<Integer> decimalNumbersOfPI = Stream.generate(()->5);
		decimalNumbersOfPI.map(n -> n + 10)
        .filter(n -> n < 15)
        .forEach(System.out::println);
	}


	static void randomZero(Integer[] coins, Supplier<Integer> randomSupplier) {
	    coins[randomSupplier.get()] = 0;
	}

}
