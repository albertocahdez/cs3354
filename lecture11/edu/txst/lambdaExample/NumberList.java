package edu.txst.lambdaExample;

import java.util.ArrayList;
import java.util.List;

public class NumberList {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(9);
		numbers.add(8);
		numbers.add(1);
		numbers.forEach(n -> System.out.println(n));
	}
}
