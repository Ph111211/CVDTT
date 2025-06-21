package Teacher;

public class ITTeacherFactory extends TeacherFactory {
    @Override
    public ITeacher createTeacher() {
        return new ITTeacher();
    }
}
