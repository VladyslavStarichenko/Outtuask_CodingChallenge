package vladyslav.outtask.view;

import vladyslav.outtask.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PriorityView {

    public void displayQueue(List<Student> studentQueue) {
        System.out.println("----- Student Queue -----");
        if (studentQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (Student student : studentQueue) {
                System.out.println(student.getName());
            }
        }
    }

    public List<String> readEventsFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of events to add");
        int totalEvents = scanner.nextInt();
        scanner.nextLine();
        List<String> events = new ArrayList<>();
        System.out.println("Enter events in form: EventName StudentName ");
        for (int i = 0; i < totalEvents; i++) {
            String event = scanner.nextLine();
            events.add(event);
        }
        scanner.close();
        return events;
    }
}
