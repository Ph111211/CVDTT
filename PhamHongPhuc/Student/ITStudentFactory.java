package Student;

public class ITStudentFactory extends StudentFactory {
    @Override
    public IStudent createStudent() {
        return new ITStudent();
    }
}
