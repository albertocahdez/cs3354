package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class StudentApp extends JFrame {
    private StudentTableModel model;
    private JTable table;

    public StudentApp() {
        List<Student> students = StudentFileUtil.loadStudents();
        model = new StudentTableModel(students);
        table = new JTable(model);

        setTitle("Student Manager");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu studentMenu = new JMenu("Student");
        JMenuItem newStudentItem = new JMenuItem("New Student");
        JMenuItem quitItem = new JMenuItem("Quit");

        newStudentItem.addActionListener(e -> showNewStudentDialog());
        quitItem.addActionListener(e -> System.exit(0));

        studentMenu.add(newStudentItem);
        studentMenu.add(quitItem);
        menuBar.add(studentMenu);
        setJMenuBar(menuBar);

        // Double-click listener
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    int row = table.getSelectedRow();
                    showStudentDetailDialog(row);
                }
            }
        });

        setVisible(true);
    }

    private void showNewStudentDialog() {
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField gpaField = new JTextField();
        JTextField majorField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("First Name:")); panel.add(firstNameField);
        panel.add(new JLabel("Last Name:")); panel.add(lastNameField);
        panel.add(new JLabel("GPA:")); panel.add(gpaField);
        panel.add(new JLabel("Major:")); panel.add(majorField);

        int result = JOptionPane.showConfirmDialog(this, panel, "New Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Student s = new Student(firstNameField.getText(), lastNameField.getText(),
                    Double.parseDouble(gpaField.getText()), majorField.getText());
            model.addStudent(s);
            StudentFileUtil.saveStudents(model.getStudentList());
        }
    }

    private void showStudentDetailDialog(int row) {
        Student s = model.getStudentAt(row);

        JTextField firstNameField = new JTextField(s.getFirstName());
        JTextField lastNameField = new JTextField(s.getLastName());
        JTextField gpaField = new JTextField(String.valueOf(s.getGpa()));
        JTextField majorField = new JTextField(s.getMajor());

        firstNameField.setEnabled(false);
        lastNameField.setEnabled(false);
        gpaField.setEnabled(false);
        majorField.setEnabled(false);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("First Name:")); panel.add(firstNameField);
        panel.add(new JLabel("Last Name:")); panel.add(lastNameField);
        panel.add(new JLabel("GPA:")); panel.add(gpaField);
        panel.add(new JLabel("Major:")); panel.add(majorField);

        JDialog dialog = new JDialog(this, "Student Details", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton deleteBtn = new JButton("Delete");
        JButton cancelBtn = new JButton("Cancel");

        buttonPanel.add(deleteBtn);
        buttonPanel.add(cancelBtn);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        deleteBtn.addActionListener(e -> {
            model.removeStudent(row);
            StudentFileUtil.saveStudents(model.getStudentList());
            dialog.dispose();
        });

        cancelBtn.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentApp::new);
    }
}