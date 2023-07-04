# Priority Queue README

## Overview

The Priority Queue is an abstract data type that allows elements to be stored and retrieved based on their priority. In this implementation, the priority is determined by the Cumulative Grade Point Average (CGPA) of the students. The queue follows the following priority criteria:

1. Students with a higher CGPA have a higher priority.
2. Students with the same CGPA are served based on their names in ascending case-sensitive alphabetical order.
3. If multiple students have the same CGPA and name, they are served in ascending order of their ID.

The `Priority` class provides a method `getStudents(List<String> events)` to process a list of events and return the students yet to be served in the priority order.

The `Student` class represents a student and implements the `Comparable` interface to enable comparison based on the priority criteria.

## Assumptions

- The solution is correct when the queue is only used once since the order of elements can be broken after dequeuing.

Example:
If we look at the queue - there is a bug found: after Anik is added, the priority does not work correctly. However, for the first iteration, it works. If we want to use this queue as a static instance container, then `PriorityQueue` is not a perfect choice here. As we can see from the output below:

```
Real queue:
[Student(id=8, name=Dan, cgpa=3.95), Student(id=5, name=Ashley, cgpa=3.9), Student(id=6, name=Maria, cgpa=3.6), Student(id=3, name=Shafaet, cgpa=3.7)]

Output:
----- Student Queue -----
Dan
Ashley
Shafaet
Maria
```

## Usage

To use the Priority Queue, follow these steps:

1. Create an instance of the `Priority` class: 

```java
Priority priority = new Priority();
```

2. Prepare a list of events that describe the students entering and leaving the queue.

3. Call the `getStudents` method with the list of events: 

```java
List<Student> students = priority.getStudents(events);
```

4. The `students` list will contain the students yet to be served in the priority order.

## Event Format

Each event in the list should be in one of the following formats:

1. `ENTER name cgpa`: Represents a student entering the queue. The `name` is the name of the student, and `cgpa` is the student's Cumulative Grade Point Average.
2. `SERVED`: Represents a student being served and removed from the queue.

## Example

Consider the following example:

```java
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
```

After processing the events, the `students` list will contain the following students yet to be served in the priority order:

```
Dan
Ashley
Shafaet
Maria
```

## Time and Space Complexity

The time complexity of the `getStudents` method is O(n log n), where n is the number of events. This is because each event requires adding or removing a student from the

 priority queue, which has a time complexity of O(log n) for each operation.

The space complexity of the `getStudents` method is O(n), where n is the number of events. This is because the students who have not been served yet are stored in a priority queue, which requires space proportional to the number of events.

## Testing

The `PriorityTest` class contains unit tests to verify the correctness of the `getStudents` method implementation. It includes tests for different scenarios, such as students with different CGPA, same CGPA and different names, and same CGPA, name, and ID. The test cases cover edge cases and ensure the expected priority order of students.

To run the tests, execute the `testGetStudents` method of the `PriorityTest` class.
