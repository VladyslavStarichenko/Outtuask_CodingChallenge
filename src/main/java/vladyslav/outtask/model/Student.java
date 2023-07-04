package vladyslav.outtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private double cgpa;
    private static int idCounter = 0;

    public Student(String name, double cgpa) {
        this.id = ++idCounter;
        this.name = name;
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student other) {
        if (this.cgpa != other.cgpa) {
            return Double.compare(other.cgpa, this.cgpa);
        } else if (!this.name.equals(other.name)) {
            return this.name.compareTo(other.name);
        } else {
            return Integer.compare(this.id, other.id);
        }
    }
}
