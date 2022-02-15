package idv.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3 {
	/*
	 * https://openhome.cc/Gossip/Java/ComparableComparator.html
	  -- Set的實作類別之一java.util.TreeSet，不僅擁有收集不重複物件之能力---
	 */
	
	public static void main(String[] args) {
        List<String> words = Arrays.asList("B", "X", "A", "M", "F", "W", "O");
//        Collections.sort(words,new StringComparator());
        Collections.sort(words);
        System.out.println(words);
        
        List<String> words1 = Arrays.asList("B", "X", "A", "M", "F", "W", "O");
        Collections.sort(words1, String::compareTo);
        System.out.println(words1);
    }
	
	/*
	 ---來考慮一個更複雜的情況，如果有個List中某些索引處包括null，現在你打算讓那些null排在最前頭，之後依字串的長度由大到小排序--- 
	 */


}
//字元顛倒排序之重構 
class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return -s1.compareTo(s2);
    }
}
