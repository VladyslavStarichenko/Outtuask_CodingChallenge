import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vladyslav.outtask.model.Priority;
import vladyslav.outtask.model.Student;

import java.util.Arrays;
import java.util.List;

public class PriorityTest {

    @Test
    public void testGetStudents_WithValidEvents_ReturnsCorrectPriorityOrder() {
        Priority priority = new Priority();
        List<String> events = Arrays.asList(
                "ENTER John 3.75",
                "ENTER Mark 3.8",
                "ENTER Shafaet 3.7",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85",
                "SERVED",
                "ENTER Ashley 3.9",
                "ENTER Maria 3.6",
                "ENTER Anika 3.95",
                "ENTER Dan 3.95",
                "SERVED"
        );
        List<Student> students = priority.getStudents(events);
        Assertions.assertEquals(4, students.size());
        Assertions.assertEquals("Dan", students.get(0).getName());
        Assertions.assertEquals("Ashley", students.get(1).getName());
        Assertions.assertEquals("Shafaet", students.get(2).getName());
        Assertions.assertEquals("Maria", students.get(3).getName());
    }

    @Test
    public void testGetStudents_WithEmptyEvents_ReturnsEmptyQueue() {
        Priority priority = new Priority();
        List<String> events = Arrays.asList();
        List<Student> students = priority.getStudents(events);
        Assertions.assertTrue(students.isEmpty());
    }

    @Test
    public void testGetStudents_WithSingleStudent_ReturnsSingleStudentInQueue() {
        Priority priority = new Priority();
        List<String> events = Arrays.asList(
                "ENTER John 3.75"
        );
        List<Student> students = priority.getStudents(events);
        Assertions.assertEquals(1, students.size());
        Assertions.assertEquals("John", students.get(0).getName());
    }

    @Test
    public void testGetStudents_WithMultipleStudentsWithSameCGPA_ReturnsSortedByNameAndId() {
        Priority priority = new Priority();
        List<String> events = Arrays.asList(
                "ENTER John 3.8",
                "ENTER Mark 3.8",
                "ENTER Alice 3.8",
                "ENTER Bob 3.8",
                "SERVED"
        );
        List<Student> students = priority.getStudents(events);
        Assertions.assertEquals(3, students.size());
        Assertions.assertEquals("Bob", students.get(0).getName());
        Assertions.assertEquals("John", students.get(1).getName());
        Assertions.assertEquals("Mark", students.get(2).getName());
    }

    @Test
    public void testGetStudents_WithEqualCGPAAndName_ReturnsSortedById() {
        Priority priority = new Priority();
        List<String> events = Arrays.asList(
                "ENTER John 3.75",
                "ENTER John 3.75",
                "ENTER John 3.75",
                "ENTER John 3.75",
                "SERVED"
        );
        List<Student> students = priority.getStudents(events);

        Assertions.assertEquals(3, students.size());
        Assertions.assertTrue(students.get(0).getId() < students.get(1).getId());
        Assertions.assertTrue(students.get(1).getId() < students.get(2).getId());
    }
}
