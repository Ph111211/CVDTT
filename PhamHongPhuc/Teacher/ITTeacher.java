package Teacher;

public class ITTeacher extends Teacher implements ITeacher {
    public ITTeacher(String maGV, String name, String ngaySinh, String gioiTinh, String maKhoa, String sdt, String email) {
        super(maGV, name, ngaySinh, gioiTinh, maKhoa, sdt, email);
    }

    public ITTeacher() {
        super();
    }

    @Override
    public void execute(Teacher Teacher) {
        System.out.println("ITTeacher handling: " + Teacher);
    }
    @Override
    public void addTeacher(ITeacher Teacher, Teacher s) {
        System.out.println("Adding Teacher");
        Teacher.execute(s);
    }
    @Override
    public void editTeacher(ITeacher Teacher, Teacher s) {
        System.out.println("Editing Teacher");
        Teacher.execute(s);
    }
    @Override
    public void deleteTeacher(ITeacher Teacher, Teacher s) {
        System.out.println("Deleting Teacher");
        Teacher.execute(s);
    }
}
