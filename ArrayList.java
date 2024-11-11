// You are using Java
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<String> Fruits = new ArrayList<String>();
        Fruits.add("Apple");
        Fruits.add("Banana");
        System.out.println("Original Array: Apple Banana ");
        String input = s.next();
        Fruits.add(input);
        System.out.printf("Array after adding a new element: ");
        for(String fruit: Fruits){
            System.out.printf(fruit + " ");
        }
    }
}




// Single File Programming Question
// Problem Statement



// Mesa, a store manager, needs a program to manage inventory items. Define a class ItemType with private attributes for name, deposit, and cost per day. Create an ArrayList in the Main class to store ItemType objects, allowing input and display.



// Note: Use "%-20s%-20s%-20s" for formatting output in tabular format, display double values with 1 decimal place.

// Input format :
// The first line of input is an integer n representing the number of items.

// For each of the n items, there are three lines:

// The name of the item (a string)
// The deposit amount (a double)
// The cost per day (a double)
// Output format :
// The output displays a formatted table with columns for name, deposit and cost per day.



// Refer to the sample output for formatting specifications.

// Code constraints :
// 1 ≤ n ≤ 100

// Sample test cases :
// Input 1 :
// 3
// Laptop
// 10000.0
// 250.0
// Light
// 1000.0
// 50.0
// Fan
// 1000.0
// 100.0
// Output 1 :
// Name                Deposit             Cost Per Day        
// Laptop              10000.0             250.0               
// Light               1000.0              50.0                
// Fan                 1000.0              100.0               
// Input 2 :
// 5
// Headphones
// 300.0
// 15.0
// Mouse
// 100.0
// 5.0
// Desk
// 800.0
// 40.0
// Printer
// 1500.0
// 70.0
// Speakers
// 1200.0
// 60.0
// Output 2 :
// Name                Deposit             Cost Per Day        
// Headphones          300.0               15.0                
// Mouse               100.0               5.0                 
// Desk                800.0               40.0                
// Printer             1500.0              70.0                
// Speakers            1200.0              60.0        

// You are using Java
import java.util.Scanner;
import java.util.ArrayList;

class ItemType{
    private String name;
    private double deposit;
    private double costPerDay;
    
    ItemType(String name, double deposit, double costPerDay){
        this.name = name;
        this.deposit = deposit;
        this.costPerDay = costPerDay;
    }
    
    String getName(){
        return name;
    }
    double getDeposit(){
        return deposit;
    }
    double getCPD(){
        return costPerDay;
    }
}

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        ArrayList<ItemType>list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String name = s.next();
            double deposit = s.nextDouble();
            double cpd = s.nextDouble();
            // s.nextLine();
            
            ItemType item = new ItemType(name, deposit, cpd);
            list.add(item);
        }
        
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Deposit", "Cost Per Day");
        
        for(ItemType item : list){
            System.out.printf("%-20s%-20s%-20s\n", item.getName(), item.getDeposit(), item.getCPD());
        }
    }
}
