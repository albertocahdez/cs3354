package edu.txst.iterableExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("orange");
		list.add("apple");
		list.add("grape");
		list.add("strawberry");
		list.add("blueberry");

		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
