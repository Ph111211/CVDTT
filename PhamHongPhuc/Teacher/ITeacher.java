package Teacher;

public interface ITeacher {
    void execute(Teacher teacher);
    void addTeacher(ITeacher teacher, Teacher s);
    void editTeacher(ITeacher teacher, Teacher s);
    void deleteTeacher(ITeacher teacher, Teacher s);
}
