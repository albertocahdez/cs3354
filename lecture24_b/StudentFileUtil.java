import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFileUtil {
    private static final String FILE_NAME = "students.txt";

    public static List<Student> loadStudents() {
        List<Student> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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
        } catch (IOException e) { e.printStackTrace(); }
        return list;
    }

    public static void saveStudents(List<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.getFirstName() + "," + s.getLastName() + "," + s.getGpa() + "," + s.getMajor());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}