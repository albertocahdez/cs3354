package com.company.ComparatorExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparisonExample {

	static class Person implements Comparable<Person> {
		String name;
		int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.age, o.age);
			// return this.age - o.age;
		}
	}

	static class ComparatorByNameDesc implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			return o2.getName().compareTo(o1.getName());
		}

	}

	public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

		Collections.sort(people);
        System.out.println("Sorted by Age (Ascending): " + people);

		// Comparator using lambda to sort by age in ascending order
        Comparator<Person> byAge = (p1, p2) -> p2.getAge() - p1.getAge();

		people.sort(byAge);
		System.out.println("Sorted by Age (Descending): " + people);

        // Comparator using lambda to sort by name in descending order
        Comparator<Person> byNameDesc = new ComparatorByNameDesc();

        people.sort(byNameDesc);
        System.out.println("Sorted by Name (Descending): " + people);
    }
}
