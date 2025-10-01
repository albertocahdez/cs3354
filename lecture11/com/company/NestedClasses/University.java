package com.company.NestedClasses;

public class University {
    private String name;
    private Department department;

    public University(String name) {
        this.name = name;
        this.department = new Department("Computer Science");
    }

    public void showInfo() {
        System.out.println("University: " + name);
        department.showInfo();
    }

    // Nested class: Department
    public class Department {
        private String name;
        private Course course;

        public Department(String name) {
            this.name = name;
            this.course = new Course("Intro to Programming");
        }

        public void showInfo() {
            System.out.println("  Department: " + name);
            course.showInfo();
        }

        // Nested class: Course
        public class Course {
            private String title;

            public Course(String title) {
                this.title = title;
            }

            public void showInfo() {
                System.out.println("    Course: " + title);
            }
        }
    }

    public static void main(String[] args) {
        University uni = new University("Tech University");
        uni.showInfo();

        University uni2 = new University("Texas University");
        University.Department course = uni2.new Department("CS");
        course.showInfo();
    }
}