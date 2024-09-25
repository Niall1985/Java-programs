import java.util.Scanner;

class Student{
  public String name;
  public int age;
  Student(String name, int age){
    this.name = name;
    this.age = age;
  }
}

class Person extends Student{
  public String dob;
  Person(String name, int age, String dob){
    super(name, age);
    this.dob = dob;
  }
  
  void display(){
    System.out.printf("%s\n%d\n%s\n", name, age, dob);
    System.out.printf("\n");
  }
}

public class Main{
  public static void main(String[] args){
    Person[] p = new Person[3];
    p[0] = new Person("Niall", 18, "03-12-2005");
    p[1] = new Person("Niall", 18, "03-12-2005");
    p[2] = new Person("Niall", 18, "03-12-2005");
    for(int i = 0 ; i < 3 ; i++){
      p[i].display();
    }
  }
}
