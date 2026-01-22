package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFileUtil {
    private static final String FILE_NAME = "students.txt";

    public static List<Student> loadStudents() {
        List<Student> list = new ArrayList<>();
        //OLD VERSION File file = new File("src/main/resources/" + FILE_NAME);
        String filePath = System.getProperty("user.home") + "/" + FILE_NAME;
        File file = new File(filePath);

        if (!file.exists()) return list;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String firstName = parts[0];
                    String lastName = parts[1];
                    double gpa = Double.parseDouble(parts[2]);
                    String major = parts[3];
                    list.add(new Student(firstName, lastName, gpa, major));
                }
                
            }
            br.close();
        } catch (IOException e) { e.printStackTrace(); }
        return list;
    }

    public static void saveStudents(List<Student> students) {
        // OLD VERSION String resourcePath = "src/main/resources/" + FILE_NAME;
        String filePath = System.getProperty("user.home") + "/" + FILE_NAME;

        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Student s : students) {
                pw.println(s.getFirstName() + "," + s.getLastName() + "," + s.getGpa() + "," + s.getMajor());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}