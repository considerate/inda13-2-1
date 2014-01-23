
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 *
 * @author Michael Kölling and David Barnes
 * @version 2011.07.31
 */
public class Student extends Person {
    // the amount of credits for study taken so far
    private int credits;

    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID) {
        super(fullName, studentID);
        credits = 0;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID() {
        return super.getId();
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints) {
        credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Get the student's name and ID number.
     */
    public String getInfo() {
        String personInfo = super.getInfo();
        return personInfo + " credits: " + getCredits();
    }

    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print() {
        System.out.println(getInfo());
    }
}
