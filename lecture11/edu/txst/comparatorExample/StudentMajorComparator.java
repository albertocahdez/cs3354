package edu.txst.comparatorExample;

import java.util.Comparator;

public class StudentMajorComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getMajor().compareTo(o2.getMajor());
	}

}
