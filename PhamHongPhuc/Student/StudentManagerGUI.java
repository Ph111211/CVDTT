package Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class StudentManagerGUI extends JFrame {
    private final JTextField tfMaSV = new JTextField();
    private final JTextField tfName = new JTextField();
    private final JTextField tfNgaySinh = new JTextField();
    private final JTextField tfGioiTinh = new JTextField();
    private final JTextField tfLop = new JTextField();
    private final JTextField tfSdt = new JTextField();
    private final JTextField tfEmail = new JTextField();
    private final JTextField tfDiaChi = new JTextField();

    private final JTable table;
    private final DefaultTableModel tableModel;
    private final ArrayList<Student> studentList = new ArrayList<>();
    private final StudentFactory factory = new ITStudentFactory();

    public StudentManagerGUI() {
        setTitle("Quản lý sinh viên");
        setSize(900, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 4));
        inputPanel.add(new JLabel("Mã SV")); inputPanel.add(tfMaSV);
        inputPanel.add(new JLabel("Họ tên")); inputPanel.add(tfName);
        inputPanel.add(new JLabel("Ngày sinh")); inputPanel.add(tfNgaySinh);
        inputPanel.add(new JLabel("Giới tính")); inputPanel.add(tfGioiTinh);
        inputPanel.add(new JLabel("Lớp")); inputPanel.add(tfLop);
        inputPanel.add(new JLabel("SĐT")); inputPanel.add(tfSdt);
        inputPanel.add(new JLabel("Email")); inputPanel.add(tfEmail);
        inputPanel.add(new JLabel("Địa chỉ")); inputPanel.add(tfDiaChi);

        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);

        tableModel = new DefaultTableModel(new String[]{
                "Mã SV", "Họ tên", "Ngày sinh", "Giới tính", "Lớp", "SĐT", "Email", "Địa chỉ"
        }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(buttonPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        btnAdd.addActionListener(e -> addStudent());
        btnEdit.addActionListener(e -> editStudent());
        btnDelete.addActionListener(e -> deleteStudent());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    tfMaSV.setText(tableModel.getValueAt(row, 0).toString());
                    tfName.setText(tableModel.getValueAt(row, 1).toString());
                    tfNgaySinh.setText(tableModel.getValueAt(row, 2).toString());
                    tfGioiTinh.setText(tableModel.getValueAt(row, 3).toString());
                    tfLop.setText(tableModel.getValueAt(row, 4).toString());
                    tfSdt.setText(tableModel.getValueAt(row, 5).toString());
                    tfEmail.setText(tableModel.getValueAt(row, 6).toString());
                    tfDiaChi.setText(tableModel.getValueAt(row, 7).toString());
                }
            }
        });
        loadFromFile();
    }

    private Student getStudentFromFields() {
        return new Student(
                tfMaSV.getText(), tfName.getText(), tfNgaySinh.getText(),
                tfGioiTinh.getText(), tfLop.getText(), tfSdt.getText(),
                tfEmail.getText(), tfDiaChi.getText()
        );
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.csv"))) {
            for (Student s : studentList) {
                writer.println(s.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student s = Student.fromCSV(line);
                if (s != null) {
                    studentList.add(s);
                    tableModel.addRow(new Object[]{
                            s.getMaSV(), s.getName(), s.getNgaySinh(), s.getGioiTinh(),
                            s.getLop(), s.getSdt(), s.getEmail(), s.getDiaChi()
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addStudent() {
        Student student = getStudentFromFields();
        IStudent s = factory.createStudent();
        s.addStudent(s, student);
        studentList.add(student);
        tableModel.addRow(new Object[]{
                student.getMaSV(), student.getName(), student.getNgaySinh(),
                student.getGioiTinh(), student.getLop(), student.getSdt(),
                student.getEmail(), student.getDiaChi()
        });
        saveToFile();
    }

    private void editStudent() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            Student student = getStudentFromFields();
            IStudent s = factory.createStudent();
            s.editStudent(s, student);
            studentList.set(row, student);
            tableModel.setValueAt(student.getMaSV(), row, 0);
            tableModel.setValueAt(student.getName(), row, 1);
            tableModel.setValueAt(student.getNgaySinh(), row, 2);
            tableModel.setValueAt(student.getGioiTinh(), row, 3);
            tableModel.setValueAt(student.getLop(), row, 4);
            tableModel.setValueAt(student.getSdt(), row, 5);
            tableModel.setValueAt(student.getEmail(), row, 6);
            tableModel.setValueAt(student.getDiaChi(), row, 7);
        }
        saveToFile();
    }

    private void deleteStudent() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            Student student = studentList.get(row);
            IStudent s = factory.createStudent();
            s.deleteStudent(s, student);
            studentList.remove(row);
            tableModel.removeRow(row);
        }
        saveToFile();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagerGUI().setVisible(true));
    }
}
