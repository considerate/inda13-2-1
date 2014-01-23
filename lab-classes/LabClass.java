import java.util.Date;
import java.util.ArrayList;

/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 *
 * @author Michael Kölling and David Barnes
 * @version 2011.07.31
 */
public class LabClass {
    private Instructor instructor;
    private Room room;
    private Date startingTime;
    private ArrayList<Student> students;
    private int capacity;

    /**
     * Create a LabClass with a maximum number of enrolments. All other details
     * are set to default values.
     */
    public LabClass(int maxNumberOfStudents) {
        this.instructor = null;
        this.room = null;
        this.startingTime = null;
        this.students = new ArrayList<Student>();
        this.capacity = maxNumberOfStudents;
    }

    /**
     * Add a student to this LabClass.
     */
    public void enrollStudent(Student newStudent) {
        if (students.size() == capacity) {
            System.out.println("The class is full, you cannot enroll.");
        } else {
            students.add(newStudent);
        }
    }

    /**
     * Return the number of students currently enrolled in this LabClass.
     */
    public int numberOfStudents() {
        return students.size();
    }

    /**
     * Set the room number for this LabClass.
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Set the starting time for this LabClass. 
     */
    public void setTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    /**
     * Set the name of the instructor for this LabClass.
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getInstructorInfo() {
        return "Instructor: " + instructor.getInfo();
    }

    public String getRoomInfo() {
        return "Room: "+ room.getInfo();
    }

    /**
     * Print out a class list with other LabClass details to the standard
     * terminal.
     */
    public void printList() {
        System.out.println("Lab class " + startingTime);
        System.out.println(getInstructorInfo() +" " + getRoomInfo());
        System.out.println("Class list:");
        for (Student student : students) {
            System.out.println(student.getInfo());
        }
        System.out.println("Number of students: " + numberOfStudents());
    }
}
