# Ödevler

1. Write a program that prints out characters in the form of a grid. The program should ask a number N from the user. The grid must be drawn as a square whose edge is N characters. The outermost characters must be * characters describing a border. Inside the border a checkerboard must be drawn using space and + characters. The top-left corner checkerboard character must be + character. Below are the outputs for 5 different values of N.

```

N=10                
**********
*+ + + + *
* + + + +*
*+ + + + *
* + + + +*
*+ + + + *
* + + + +*
*+ + + + *
* + + + +*
**********

N=5
*****
*+ +*
* + *
*+ +*
*****

N=1
*

N=3
***
*+*
***

N=4
****
*+ *
* +*
****

```

2. Write a program that requests a pattern string from the user. The pattern includes wild card character `*` in addition to any other characters. Each occurrence of the wild chard character represents a sequence of any characters. After getting the pattern, the program continuously requests the user to enter a string and checks if the pattern occurs in the string using a method public static boolean `occursIn(String pattern, String str)`. The program will exit when the user enters **exit**.

```
Enter the pattern string: s*h*l

Enter a string: school
s*h*l occurs in ”school”

Enter a string: okul
s*h*l does NOT occur in ”okul”

Enter a string: salaries are neither high nor low
s*h*l occurs in ”salaries are neither high nor low”

Enter a string: This is a good school, isn’t it? 
s*h*l occurs in ”This is a good school, isn’t it?”

Enter a string: I love programming 
s*h*l does NOT occur in ”I love programming”

Enter a string: exit
Bye
```

3. 
* Implement the PersonalData class with the following UML diagram.

```plantuml
class PersonalData {
        - java.time.LocalDate:birthDate
        - String:address
        - long:ssn
        + PersonalData(java.time.LocalDate,long)
        + PersonalData(int,int,int,long)
        + getBirthDate():java.time.LocalDate
        + getAddress():String
        + getSSN():long
        + setAddress(String):void
    }
```
![PersonalData](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/Izmir-Java-Bootcamp/homework-1/main/personalData.txt)

A PersonalData object is created using one of the two constructors.  First constructor uses `java.time.LocalDate` and social security number (SSN) data.  Second constructor uses three integers and a long value.  The three integers correspond to year, month and day values of a date, while long value corresponds to the SSN.  In the implementation of the second constructor, you must use **this** keyword.

* Implement the Student class with the following UML diagram.

```plantuml
class Student {
        - String:name
        - long:id
        - double:gpa
        - PersonalData:pd
        + Student(String,long,double,PersonalData)
        + getName():String
        + getID():long
        + getGPA():double
        + getPersonalData():PersonalData
        + toString():String
    }
```
![Student](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/Izmir-Java-Bootcamp/homework-1/main/student.txt)

A student object is created by specifying his/her name, ID, GPA and personal data. 
A student object can be expressed as a String by simply concatenating its name, ID and GPA successively.

* Revise the Course class according to the following UML diagram.

```plantuml
class Course {
        - String:name
        - Student[]:students
        - int:capacity
        - int:numberOfStudent
        + Course(String)
        + Course(String, int)
        + getNumberOfStudents():int
        + getCourseName():String
        + getStudents():Student[]
        + addStudent(Student):boolean
        + dropStudent(Student):boolean
        + increaseCapacity():void 
        + getBestStudent():Student
        + getYoungestStudent():Student
        + clear():void
        + list():void
        + toString():String

    }
```
![Course](https://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/Izmir-Java-Bootcamp/homework-1/main/course.txt)

Each course object has a **capacity**.  A course is created in two ways; either by specifying only its name or by specifying its **name** and **capacity**.  Default **capacity** value for a course object is 40. You must use **this** keyword in the implementation of first constructor. 

**numberOfStudents** holds the number of students currently enrolled to the course.

It uses an array of **Students** to store the students for the course.

`addStudent(Student)` method adds a student to the array.  While adding the student to the array, the capacity of the course should not be exceeded and a student cannot be added to the course for the second time (remember that a student is uniquely identified by his/her ID).  If the student is added to the course, **numberOfStudents** is increased by one and the method returns true, else it returns false.

`dropStudent(Student)` method deletes the student from the array.  If the student is found in the array, then the student is deleted from the array, **numberOfStudents** is decreased by one and the method returns true, else the method returns false.

`increaseCapacity()` method increases the capacity of the course by 5.

`getBestStudent()` method returns the student with greatest GPA.

`getYoungestStudent()` method returns the youngest student.  You may use the `compareTo(java.time.LocalDate)` method defined in `java.time.LocalDate` class.

`clear()` method removes all students from the course.

`list()` method prints all students enrolled to the course to the screen.

A course object is expressed as a String by concatenating its name, number of students enrolled to the course and each enrolled student’s ID, successively.

* Write a test program in which the following are performed in order.
    - 5 students are created.  Let one of them has the ID 5005.  
    - A course (let us call it K129) with a capacity of 3 is created
    - Any 4 of the students is added to K129.  
    - All students of K129 are printed on the screen.
    - The capacity of K129 is increased.
    - Remaining 2 students are added to K129.
    - All students of K129 are printed on the screen.
    - Student with ID 5005 is dropped from K129.
    - All students of K129 are printed on the screen.
    - Number of students enrolled to K129 is printed.
    - Birth year of best student of K129 is printed on the screen. (You should use -  getYear() method of java.util.Date class.)
    - A new course (let us call it K130) is created.
    - All students currently enrolled in K129 are added to K130. (You should use -  getStudents() method).
    - All students of K129 are removed from the course.
    - Student with ID 5005 is dropped from K129 and result of the operation is    printed - on the screen.
    - All students of K130 are printed on the screen.
    - Best student of K130 is dropped from K130.
    - All students of K130 are printed on the screen.
    - GPA of youngest student of K130 is printed on the screen.
    - Courses K129 and K130 are printed on the screen.


## Kaynaklar
- [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html#:~:text=LocalDate%20is%20an%20immutable%20date,be%20stored%20in%20a%20LocalDate%20.)