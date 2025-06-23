package Teacher;

import Student.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class TeacherManagerGUI extends JFrame {
    private final JTextField tfMaGV = new JTextField();
    private final JTextField tfName = new JTextField();
    private final JTextField tfNgaySinh = new JTextField();
    private final JTextField tfGioiTinh = new JTextField();
    private final JTextField tfMaKhoa = new JTextField();
    private final JTextField tfSdt = new JTextField();
    private final JTextField tfEmail = new JTextField();

    private final JTable table;
    private final DefaultTableModel tableModel;
    private final ArrayList<Teacher> TeacherList = new ArrayList<>();
    private final TeacherFactory factory = new ITTeacherFactory();

    public TeacherManagerGUI() {
        setTitle("Quản lý giảng viên");
        setSize(900, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 4));
        inputPanel.add(new JLabel("Mã GV")); inputPanel.add(tfMaGV);
        inputPanel.add(new JLabel("Họ tên")); inputPanel.add(tfName);
        inputPanel.add(new JLabel("Ngày sinh")); inputPanel.add(tfNgaySinh);
        inputPanel.add(new JLabel("Giới tính")); inputPanel.add(tfGioiTinh);
        inputPanel.add(new JLabel("Mã Khoa")); inputPanel.add(tfMaKhoa);
        inputPanel.add(new JLabel("SĐT")); inputPanel.add(tfSdt);
        inputPanel.add(new JLabel("Email")); inputPanel.add(tfEmail);

        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);

        tableModel = new DefaultTableModel(new String[]{
                "Mã GV", "Họ tên", "Ngày sinh", "Giới tính", "Mã khoa", "SĐT", "Email"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(buttonPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        btnAdd.addActionListener(e -> addTeacher());
        btnEdit.addActionListener(e -> editTeacher());
        btnDelete.addActionListener(e -> deleteTeacher());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    tfMaGV.setText(tableModel.getValueAt(row, 0).toString());
                    tfName.setText(tableModel.getValueAt(row, 1).toString());
                    tfNgaySinh.setText(tableModel.getValueAt(row, 2).toString());
                    tfGioiTinh.setText(tableModel.getValueAt(row, 3).toString());
                    tfMaKhoa.setText(tableModel.getValueAt(row, 4).toString());
                    tfSdt.setText(tableModel.getValueAt(row, 5).toString());
                    tfEmail.setText(tableModel.getValueAt(row, 6).toString());
                }
            }
        });
        loadFromFile();
    }

    private Teacher getTeacherFromFields() {
        return new Teacher(
                tfMaGV.getText(), tfName.getText(), tfNgaySinh.getText(),
                tfGioiTinh.getText(), tfMaKhoa.getText(), tfSdt.getText(),
                tfEmail.getText()
        );
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("teachers.csv"))) {
            for (Teacher t : TeacherList) {
                writer.println(t.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("teachers.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Teacher t = Teacher.fromCSV(line);
                if (t != null) {
                    TeacherList.add(t);
                    tableModel.addRow(new Object[]{
                            t.getMaGV(), t.getName(), t.getNgaySinh(), t.getGioiTinh(),
                            t.getMaKhoa(), t.getSdt(), t.getEmail()
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTeacher() {
        Teacher Teacher = getTeacherFromFields();
        ITeacher s = factory.createTeacher();
        s.addTeacher(s, Teacher);
        TeacherList.add(Teacher);
        tableModel.addRow(new Object[]{
                Teacher.getMaGV(), Teacher.getName(), Teacher.getNgaySinh(),
                Teacher.getGioiTinh(), Teacher.getMaKhoa(), Teacher.getSdt(),
                Teacher.getEmail(),
        });
        saveToFile();
    }

    private void editTeacher() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            Teacher Teacher = getTeacherFromFields();
            ITeacher s = factory.createTeacher();
            s.editTeacher(s, Teacher);
            TeacherList.set(row, Teacher);
            tableModel.setValueAt(Teacher.getMaGV(), row, 0);
            tableModel.setValueAt(Teacher.getName(), row, 1);
            tableModel.setValueAt(Teacher.getNgaySinh(), row, 2);
            tableModel.setValueAt(Teacher.getGioiTinh(), row, 3);
            tableModel.setValueAt(Teacher.getMaKhoa(), row, 4);
            tableModel.setValueAt(Teacher.getSdt(), row, 5);
            tableModel.setValueAt(Teacher.getEmail(), row, 6);
        }
        saveToFile();
    }

    private void deleteTeacher() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            Teacher Teacher = TeacherList.get(row);
            ITeacher s = factory.createTeacher();
            s.deleteTeacher(s, Teacher);
            TeacherList.remove(row);
            tableModel.removeRow(row);
        }
        saveToFile();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TeacherManagerGUI().setVisible(true));
    }
}
