package idv.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
		
		/*
		 * 參考連結如下 完成 functional 練習
		 * https://openhome.cc/Gossip/Java/ConsumerFunctionPredicateSupplier.html
		 */
	
		/*
		 * Consumer Practice -> 接受一個引數，然後處理後不傳回值
		 */
		
		Arrays.asList("Justin", "Monica", "Irene").forEach(System.out::println);
		
		/*
		 * Functional Practice -> 是接受一個引數，然後以該引數進行計算後傳回結果
		 */

		Optional<String> nickOptional = getNickName1("Justin");
		System.out.println(nickOptional.map(String::toUpperCase));  // 顯示 CATERPILLAR
		
		/*
		 * Predicate -> 接受一個引數，然後只傳回boolean值
		 */
	
		String[] fileNames = {"abc.txt","c22.txt","pp.jpg","wow.png"};
		long count = Stream.of(fileNames)
                .filter(name -> name.endsWith("txt"))
                .count();
		System.out.println("count = "+count);
		
		/*
		 * Supplier -> 不接受任何引數，然後傳回值
		 */
		
		Integer[] coins = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};     
		randomZero(coins, () -> (int) (Math.random() * 10));
		Arrays.asList(coins).forEach(System.out::println); // Consumer
		
		// Never done but not crash --> won't out of memory !!
		/*
		 * 使用Stream的原因是可以像個清單似地操作，而實際上在forEach()真正消耗某個數字之前，
		 * 並不會真正去呼叫nextDecimalNumberOfPI()，消耗掉的數字也不會被保留，因而不會耗費記憶體，
		 * 因而可以實現無限長度清單的概念。
		 */
//		Stream<Integer> decimalNumbersOfPI = Stream.generate(()->5);
//		decimalNumbersOfPI.map(n -> n + 10)
//        .filter(n -> n < 15)
//        .forEach(System.out::println);
	}
	static Optional<String> getNickName(String name) {
        Map<String, String> nickNames = new HashMap<>();
        nickNames.put("Justin", "caterpillar");
        nickNames.put("Monica", "momor");
        nickNames.put("Irene", "hamimi");
        String nickName = nickNames.get(name);
        return nickName == null ? Optional.empty() : Optional.of(nickName);
    }
	static Optional<String> getNickName1(String name) {
        Map<String, String> nickNames = new HashMap<>();
        nickNames.put("Justin", "caterpillar");
        nickNames.put("Monica", "momor");
        nickNames.put("Irene", "hamimi");
        return Optional.ofNullable(nickNames.get(name));
    }



	static void randomZero(Integer[] coins, Supplier<Integer> randomSupplier) {
	    coins[randomSupplier.get()] = 0;
	}

}
