package Student;

public class ITStudent extends Student implements IStudent {
    public ITStudent(String maSV, String name, String ngaySinh, String gioiTinh, String lop, String sdt, String email, String diaChi) {
        super(maSV, name, ngaySinh, gioiTinh, lop, sdt, email, diaChi);
    }

    public ITStudent() {
        super();
    }

    @Override
    public void execute(Student student) {
        System.out.println("ITStudent handling: " + student);
    }
    @Override
    public void addStudent(IStudent student, Student s) {
        System.out.println("Adding student");
        student.execute(s);
    }
    @Override
    public void editStudent(IStudent student, Student s) {
        System.out.println("Editing student");
        student.execute(s);
    }
    @Override
    public void deleteStudent(IStudent student, Student s) {
        System.out.println("Deleting student");
        student.execute(s);
    }
}
