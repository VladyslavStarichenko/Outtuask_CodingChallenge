package vladyslav.outtask.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priority {
    private final PriorityQueue<Student> queue = new PriorityQueue<>(
            Comparator.comparing(Student::getCgpa).reversed()
                    .thenComparing(Student::getName)
                    .thenComparing(Student::getId));
    public List<Student> getStudents(List<String> events) {
        queueing(events, queue);
        List<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }
        return students;
    }

    private static void queueing(List<String> events, PriorityQueue<Student> queue) {
        for (String event : events) {
            String[] parts = event.split(" ");
            String eventType = parts[0];
            if (eventType.equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                queue.add(new Student(name, cgpa));
            } else if (eventType.equals("SERVED")) {
                queue.poll();
            }
        }
    }
}
