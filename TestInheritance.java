class Person {}
class Teacher extends Person {}
class Student extends Person {}
class PhDStudent extends Student {}


public class TestInheritance {
	public static void main(String[] args) {
		new TestInheritance();
	}
	public TestInheritance() {
		testDeclaration();
	}

	private void testDeclaration() {
		Person p1 = new Student();  //legal
		Person p2 = new PhDStudent(); //legal
		PhDStudent phd1 = new Student(); //illegal cannot store general (super class) in sub class PhDStudent
		Teacher t1 = new Person(); //illegal cannot store super class in type Teacher of sub class of Person
		Student s1 = new PhDStudent(); //legal
	}

	private void testAssignments() {
		Person p1 = new Person();
		Person p2 = new Person();
		PhDStudent phd1 = new PhDStudent();
		Teacher t1 = new Teacher();
		Student s1 = new Student();

		s1 = p1; //illegal
		s1 = p2; //illegal
		p1 = s1; //legal
		t1 = s1; //illegal
		s1 = phd1; //legal
		phd1 = s1; //illegal
	}
}