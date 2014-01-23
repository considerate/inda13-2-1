inda13-2-1
==========

Exercise 1 for spring 2014 in Introduction to Computer Science.

##Exercise 8.12 
Assume that we have four classes: Person, Teacher, Student, and
PhDStudent. Teacher and Student are both subclasses of Person. PhDStudent is a
subclass of Student.
a. Which of the following assignments are legal, and why or why not?
```java
Person p1 = new Student();  //legal
Person p2 = new PhDStudent(); //legal
PhDStudent phd1 = new Student(); //illegal cannot store general (super class) in sub class PhDStudent
Teacher t1 = new Person(); //illegal cannot store super class in type Teacher of sub class of Person
Student s1 = new PhDStudent(); //legal
```

You can not assign instances of a less specific type to one of a higher specificity.

b. Suppose that we have the following legal declarations and assignments:
```java
Person p1 = new Person();
Person p2 = new Person();
PhDStudent phd1 = new PhDStudent();
Teacher t1 = new Teacher();
Student s1 = new Student();
```

Based on those just mentioned, which of the following assignments are legal, and why or why not?
```java
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

-----------------------

#Uppgifter från KTH

Här är två algoritmer som beräknar xn, där x är ett flyttal och n ett ickenegativt heltal.
```java
double expIterativ(double x, int n) {
    double res = 1.0;

    for (int i = 0; i < n; i++) {
        res *= x;
        //Invariant: res = 1, x^1, x^2, x^3 ... x^i
    }
    return res;
}

double expRekursiv(double x, int n) {
    if (n <= 4) {
        return expIterativ(x, n);
    }

    return expRekursiv(x, n/2) *
           expRekursiv(x, (n + 1)/2);
}
```

##1
Argumentera för att algoritmerna är korrekta. Du kan till exempel använda en loopinvariant respektive ett induktionsbevis.

Iterativ: se kommentar ovan.
Rekursiv: 
Antag att basen `x = 2`.
Vi inleder med basfallet 
`P(0) = 1` vilket är sant eftersom `x^0 = 1`
Sedan finner vi  

`P(1) = 2` och  
`P(2) = 4` vilket också är sant. (x^1 och x^2)

Vi ser sedan att `P(i)` är sant för alla `i < k` och låter k vara ett allt större tal och gå mot oändligheten vilket bevisar korrekthet för algoritmen då `x = 2` för alla positiva heltal av `i`. Vi gör om samma test för andra värden på x och bevisar sålunda vår algoritm för alla heltal av n och alla positiva baser av x. 

##2
Beräkna tidskomplexiteten som en funktion av n för båda algoritmerna. Ange resultatet med hjälp av ordo-notation.

Mästarsatsen ger att för två konstanter `a ≥ 1` och `b > 1`, en funktion `f(n)` och en funktion `T(n)` över de positiva talen som är definierad av rekursionen 

`T(n) = aT(n/b) + f(n)`.

Om f(n) = Θ(n<sup>d</sup>), där `d ≥ 0`, så gäller

T(n) = Θ(n<sup>d</sup>) om a < b<sup>d</sup>,

T(n) = Θ(n<sup>d</sup>log n) om a = b<sup>d</sup>,

T(n) = Θ(n<sup>log<sub>b</sub>a</sup>) om a > b<sup>d</sup>.

Svar: 

I fallet ovan är f(n) = 1 då arbetet endast sker max 4 gånger iterativt plus en multiplikationsoperation vilket i större perspektiv kan anses vara ett konstant arbete. 

f(n) = 1 = Θ(n<sup>0</sup>) ⇒ d = 0  

I den rekursiva funktionen ovan anropar den sig själv 2 gånger vilket medför att `a = 2` inom anropet divideras n med 2 och därför är `b = 2`.

a = 2, b = 2 och d = 0 medför att  
2<sup>0</sup> = 1 < 2,  
a > b<sup>d</sup>  

Allstå, T(n) = Θ(n<sup>log<sub>2</sub>2</sup>) = Θ(n).


