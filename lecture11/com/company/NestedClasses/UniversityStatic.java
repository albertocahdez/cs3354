package com.company.NestedClasses;

public class UniversityStatic {
    private String name;

    public UniversityStatic(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("University: " + name);
    }

    // Static nested class
    public static class Department {
        private String name;

        public Department(String name) {
            this.name = name;
        }

        public void showInfo() {
            System.out.println("  Department: " + name);
        }

        // Another static nested class
        public static class Course {
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
        UniversityStatic uni = new UniversityStatic("Tech University");
        uni.showInfo();

        UniversityStatic.Department dept = new UniversityStatic.Department("Computer Science");
        dept.showInfo();

        UniversityStatic.Department.Course course = new UniversityStatic.Department.Course("Intro to Programming");
        course.showInfo();
    }
}