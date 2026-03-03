package edu.txst.listExample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ListInsertions {

	static final int OPERATION_NUMBER = 100000;

	static void runArrayList() {
		System.out.println("== ArrayList");
		long startTimeA = System.nanoTime();
		List<Integer> firstList = new ArrayList<Integer>();
		for (int i = 0; i < OPERATION_NUMBER; i++)
			firstList.add(i);
		long endTimeA = System.nanoTime();
		long intervalA = endTimeA - startTimeA;
		System.out.println("---- ArrayList insertions at the end: " + intervalA / 1000000.0 + "ms");
		long startTimeB = System.nanoTime();
		List<Integer> secondList = new ArrayList<Integer>();
		for (int i = 0; i < OPERATION_NUMBER; i++)
			secondList.add(0, i);
		long endTimeB = System.nanoTime();
		long intervalB = endTimeB - startTimeB;
		System.out.println(
				"---- ArrayList insertions at the beginning: " + intervalB / 1000000.0 + "ms");
	}

	static void runLinkedList() {
		System.out.println("== LinkedList");
		long startTimeA = System.nanoTime();
		List<Integer> firstList = new LinkedList<Integer>();
		for (int i = 0; i < OPERATION_NUMBER; i++)
			firstList.add(i);
		long endTimeA = System.nanoTime();
		long intervalA = endTimeA - startTimeA;
		System.out
				.println("---- LinkedList insertions at the end: " + intervalA / 1000000.0 + "ms");
		long startTimeB = System.nanoTime();
		List<Integer> secondList = new LinkedList<Integer>();
		for (int i = 0; i < OPERATION_NUMBER; i++)
			secondList.add(0, i);
		long endTimeB = System.nanoTime();
		long intervalB = endTimeB - startTimeB;
		System.out.println(
				"---- LinkedList insertions at the beginning: " + intervalB / 1000000.0 + "ms");
	}

	static void runVector() {
		System.out.println("== Vector");
		long startTimeA = System.nanoTime();
		List<Integer> firstList = new Vector<Integer>();
		for (int i = 0; i < OPERATION_NUMBER; i++)
			firstList.add(i);
		long endTimeA = System.nanoTime();
		long intervalA = endTimeA - startTimeA;
		System.out.println("---- Vector insertions at the end: " + intervalA / 1000000.0 + "ms");
		long startTimeB = System.nanoTime();
		List<Integer> secondList = new Vector<Integer>();
		for (int i = 0; i < OPERATION_NUMBER; i++)
			secondList.add(0, i);
		long endTimeB = System.nanoTime();
		long intervalB = endTimeB - startTimeB;
		System.out.println(
				"---- Vector insertions at the beginning: " + intervalB / 1000000.0 + "ms");
	}

	static void runStack() {
		System.out.println("== Stack");
		long startTimeA = System.nanoTime();
		List<Integer> firstList = new Stack<Integer>();
		for (int i = 0; i < OPERATION_NUMBER; i++)
			firstList.add(i);
		long endTimeA = System.nanoTime();
		long intervalA = endTimeA - startTimeA;
		System.out.println("---- Stack insertions at the end: " + intervalA / 1000000.0 + "ms");
		long startTimeB = System.nanoTime();
		List<Integer> secondList = new Stack<Integer>();
		for (int i = 0; i < OPERATION_NUMBER; i++)
			secondList.add(0, i);
		long endTimeB = System.nanoTime();
		long intervalB = endTimeB - startTimeB;
		System.out
				.println("---- Stack insertions at the beginning: " + intervalB / 1000000.0 + "ms");
	}

	public static void main(String[] args) {
		runArrayList();
		runLinkedList();
		runVector();
		runStack();
	}
}
