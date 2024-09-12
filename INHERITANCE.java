// You are using Java
import java.util.Scanner;

class Person{
    protected String firstName;
    protected String lastName;
    protected int id;
    
    Person(String firstName,String lastName, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    void printPerson(){
        System.out.printf("Name: %s %s\nID: %d\n", firstName,lastName,id);
    }
}

class Student extends Person{
    private int[] arr;
    // private int n;
    Student(String firstName,String lastName, int id, int arr[]){
        super(firstName, lastName, id);
     
        this.arr = arr;
    }
    
    void method(){
        int sum = 0;
        for(int score:arr){
            sum += score;
        }
        int avg = sum/arr.length;
        
        if(avg>=90 && avg<=100){
            System.out.printf("Grade: O");
        }
        else if(avg>=80 && avg<90){
            System.out.printf("Grade: E");
        }
        else if(avg>=70 && avg<80){
            System.out.printf("Grade: A");
        }
        else if(avg>=55 && avg<70){
            System.out.printf("Grade: P");
        }
        else if(avg>=40 && avg<55){
            System.out.printf("Grade: D");
        }
        else if(avg<40){
            System.out.printf("Grade: T");
        }
        else{
            System.out.printf("Invalid input");
        }
    }
}


public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String fn = s.next();
        String ln = s.next();
        int id = s.nextInt();
        int n = s.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = s.nextInt();
        }
        
        Student std = new Student(fn,ln,id,arr);
        std.printPerson();
        std.method();
    }
}




// Problem Statement



// Riya is a teacher who is passionate about assessing her students fairly. She is developing a program to calculate the grades of her students based on their test scores. 



// Implement a program that models the grade calculation of a student. 



// Follow the class hierarchy and details provided below:

// Person Class:
// Create a class named Person with protected instance variables firstName, lastName, and idNumber.
// Create a constructor in the Person class that takes three parameters (firstName, lastName, and idNumber) and initializes the instance variables.
// Implement a method named printPerson in the Person class that prints the name and ID of the person.
//   Student Class:
// Create a class named Student that extends the Person class.
// Add a private instance variable testScores, which is an array of integers representing the test scores of the student.
// Create a constructor in the Student class that takes four parameters (firstName, lastName, id, and testScores) and calls the constructor of the superclass using the super keyword.
// Implement a method named calculate() in the Student class that calculates and returns the grade based on the average of the test scores. 
// The grading scale is as follows:
						



// Main Class:
// In the Main class, use a Scanner to take input for the firstName, lastName, id, and the number of test scores (numScores).
// Take input for the test scores and create an object of the Student class using the provided input values.
// Invoke the printPerson method on the Student object to print the name and ID of the student.
// Invoke the calculate method on the Student object to calculate and print the grade.
// Input format :
// The first line of input consists of a string representing the first name.

// The second line consists of a string representing the last name.

// The third line consists of an integer representing the id.

// The fourth line consists of the number of test scores.

// The fifth line consists of an integer array of test scores, separated by a single space.

// Output format :
// The output displays the name, ID and grade of the student in separate lines.



// Refer to the sample output for formatting specifications.

// Code constraints :
// 0 ≤ test scores ≤ 100

// Sample test cases :
// Input 1 :
// Shruthi
// Ramesh
// 50
// 5
// 70 80 90 87 99
// Output 1 :
// Name: Shruthi Ramesh
// ID: 50
// Grade: E
// Input 2 :
// Monica
// Geller
// 51
// 7
// 36 35 40 45 49 47 41
// Output 2 :
// Name: Monica Geller
// ID: 51
// Grade: D
