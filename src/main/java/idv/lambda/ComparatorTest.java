package idv.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
	
	/*
	 * 函數式介面
	 https://codingnote.cc/zh-tw/p/184466/
	 */
	
	public static void main(String argsp[]) {
		
		// Comparator排序
		List<Integer> list = Arrays.asList(3, 1, 4, 5, 2);
		System.out.println("sort before");
		System.out.println(list);
//		list.sort(new Comparator<Integer>() {
//		    @Override
//		    public int compare(Integer o1, Integer o2) {
//		        return o1.compareTo(o2);
//		    }
//		});
		
		// 使用Lambda表達式簡化
//		list.sort((o1, o2) -> o1.compareTo(o2));
		
		// 更加簡化的lambda
		list.sort(Integer::compareTo);
		
		System.out.println("sort after");
		System.out.println(list);
		
		
	}
	
	

}
