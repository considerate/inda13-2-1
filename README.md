inda13-2-1
==========

Exercise 1 for spring 2014 in Introduction to Computer Science.

##Exercise 8.12 
Assume that we have four classes: Person, Teacher, Student, and
PhDStudent. Teacher and Student are both subclasses of Person. PhDStudent is a
subclass of Student.
a. Which of the following assignments are legal, and why or why not?
```
Person p1 = new Student();  //legal
Person p2 = new PhDStudent(); //legal
PhDStudent phd1 = new Student(); //illegal cannot store general (super class) in sub class PhDStudent
Teacher t1 = new Person(); //illegal cannot store super class in type Teacher of sub class of Person
Student s1 = new PhDStudent(); //legal
```

You can not assign instances of a less specific type to one of a higher specificity.

b. Suppose that we have the following legal declarations and assignments:
```
Person p1 = new Person();
Person p2 = new Person();
PhDStudent phd1 = new PhDStudent();
Teacher t1 = new Teacher();
Student s1 = new Student();
```

Based on those just mentioned, which of the following assignments are legal, and why or why not?
```
s1 = p1; //legal
s1 = p2; //legal
p1 = s1; //illegal
t1 = s1; //illegal
s1 = phd1; //legal
phd1 = s1; //illegal
```

Yet again, you are allowed to assign a class with higher specificity (a subclass) to one of lower (a superclass). But the opposite is not legal in Java. 

##Exercise 8.14 
What has to change in the NewsFeed class when another Post subclass
(for example, a class EventPost) is added? Why?

Nothing, as long as the EventPost does not break in any of implementations of  the methods called from NewsFeed. This is because EventPost is a subclass of Post and as such it inherits all properties and behavior of the Post class.

##Exercise 8.15 
Use the documentation of the Java standard class libraries to find out about the inheritance hierarchy of the collection classes. Draw a diagram showing the hierarchy. 

##Exercise 8.16 
Go back to the lab-classes project from Chapter 1. Add instructors to the pro- ject (every lab class can have many students and a single instructor). Use inheritance to avoid code duplication between students and instructors (both have a name, contact details, etc.).

[Implementation](lab-classes)
