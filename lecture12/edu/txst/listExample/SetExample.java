package edu.txst.listExample;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetExample {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("A", "B", 3.25, "CS"));
		studentList.add(new Student("C", "D", 3.5, "NUR"));
		studentList.add(new Student("E", "F", 4.0, "BBA"));
		studentList.add(new Student("G", "H", 3.7, "BIO"));
		studentList.add(new Student("I", "J", 3.5, "CS"));

		Set<Student> hashSet = new HashSet<Student>();
		Set<Student> linkedHashSet = new LinkedHashSet<Student>();
		Set<Student> treeSet = new TreeSet<Student>();

		for (Student student : studentList) {
			hashSet.add(student);
			linkedHashSet.add(student);
			treeSet.add(student);
		}

		System.out.println("Hash Set: " + hashSet);
		System.out.println("Linked Hash Set: " + linkedHashSet);
		System.out.println("Tree Set: " + treeSet);


		Set<String> safeSet = new CopyOnWriteArraySet<>();
		safeSet.add("ServiceA");

		// This won't crash even if another thread adds "ServiceB" during the loop
		for (String s : safeSet) {
			System.out.println("Processing: " + s);
		}

		enum Days {
			MON, TUE, WED, THU, FRI
		};

		Set<Days> enumSet = EnumSet.range(Days.MON, Days.FRI);
		System.out.println("Enum Set: " + enumSet);

		System.out.println("=== Navigable set");
		NavigableSet<Student> navigableSet = (NavigableSet<Student>) treeSet;
		System.out.println("First: " + navigableSet.first());
		System.out.println("Last: " + navigableSet.last());
		System.out.println("Ceiling: " + navigableSet.ceiling(new Student("C", "X", 3.6, "CS")));
	}
}
