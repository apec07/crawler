package idv.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort1 {
	
	public static void main(String arg[]) {
		List<Account> accounts =Arrays.asList(
                new Account("Justin", "X1234", 1000),
                new Account("Monica", "X5678", 500),
                new Account("Irene", "X2468", 200)
        );
		List<Integer> numbers = Arrays.asList(5,3,2);
//		Collections.sort(accounts);
		Collections.sort(numbers);
		System.out.println(numbers);
		
	}
}

class Account {
    private String name;
    private String number;
    private int balance;

    Account(String name, String number, int balance) {
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Account(%s, %s, %d)", name, number, balance);
    } 
}
