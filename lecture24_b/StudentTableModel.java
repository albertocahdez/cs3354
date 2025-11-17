import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    private final String[] columns = {"First Name", "Last Name", "GPA", "Major"};
    private final List<Student> students;

    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudentList() {
        return this.students;
    }

    @Override
    public int getRowCount() { return students.size(); }

    @Override
    public int getColumnCount() { return columns.length; }

    @Override
    public String getColumnName(int col) { return columns[col]; }

    @Override
    public Object getValueAt(int row, int col) {
        Student s = students.get(row);
        switch (col) {
            case 0: return s.getFirstName();
            case 1: return s.getLastName();
            case 2: return s.getGpa();
            case 3: return s.getMajor();
            default: return null;
        }
    }

    public Student getStudentAt(int row) {
        return students.get(row);
    }

    public void addStudent(Student s) {
        students.add(s);
        fireTableRowsInserted(students.size() - 1, students.size() - 1);
    }

    public void removeStudent(int index) {
        students.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public void updateStudent(int index, Student s) {
        students.set(index, s);
        fireTableRowsUpdated(index, index);
    }
}