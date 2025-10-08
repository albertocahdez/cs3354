package com.company.CollectionExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionExampleMain {
	public static void main(String[] args) {
		Collection<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		list.add("orange");
		list.add("blueberry");
		list.add("watermelon");

		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("----------------------");

		for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
			String s = it.next();
			if (!s.endsWith("e")) {
				System.out.println(s);
			}
		}
	}

}