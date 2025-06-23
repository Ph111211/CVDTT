package Student;

public interface IStudent {
    void execute(Student student);
    void addStudent(IStudent student, Student s);
    void editStudent(IStudent student, Student s);
    void deleteStudent(IStudent student, Student s);
}
