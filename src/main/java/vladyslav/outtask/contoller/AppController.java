package vladyslav.outtask.contoller;

import vladyslav.outtask.model.Priority;
import vladyslav.outtask.model.Student;
import vladyslav.outtask.utils.AppUtil;
import vladyslav.outtask.view.PriorityView;

import java.util.List;

public class AppController {
    public static void main(String[] args) {
        AppUtil appUtil = new AppUtil();
        Priority priority = new Priority();
        PriorityView priorityView = new PriorityView();
//        List<String> events = priorityView.readEventsFromConsole();
        List<String> events = appUtil.innitData();
        List<Student> students = priority.getStudents(events);
        priorityView.displayQueue(students);
    }


}
