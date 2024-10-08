// You are using Java
import java.util.Scanner;

public class Main{
    
    public void validateGrade(String name, int grade){
        
            if(grade<0 || grade>100){
                throw new IllegalArgumentException(String.format("Invalid grade: Invalid grade: %d", grade));
            }
            else{
                System.out.printf("Grade for %s: %d", name, grade);
            }
        
        
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Main m = new Main();
        try{
            String name = s.next();
            String grade = s.next();
            
            int grade_val = Integer.parseInt(grade);
            
            m.validateGrade(name, grade_val);
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input: " + e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}







// You are using Java
import java.util.Scanner;

class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        try{
            String input = s.nextLine();
            String[] parts = input.split(" ");
            if(parts.length != 2){
                throw new MyException("Invalid input. Please enter valid exam scores.");
            }
            else{
                double n1 = Double.parseDouble(parts[0]);
                double n2 = Double.parseDouble(parts[1]);
                double avg = (n1+n2)/2;
                if(avg>=60){
                    System.out.printf("Your average grade is %.1f. You Passed the exam.", avg);
                }
                else{
                    System.out.printf("Your average grade is %.1f. You Failed the exam.", avg);
                }
            }
        }
        catch(MyException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter valid exam scores.");
        }
    }
}










import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        try {
            // Read the array size
            int n = s.nextInt();
            
            // Initialize an array of size 'n'
            int[] arr = new int[n];
            
            // Try reading exactly 'n' integers
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            
            // Check if there are more input elements than array size
            if (s.hasNext()) {
                throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException: Input elements exceeds array size");
            }
            
            // Print the elements of the array
            System.out.print("Array: ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // New line after printing array

        } catch (ArrayIndexOutOfBoundsException e) {
            // Catch the exception if user enters more elements than the array size
            System.out.println(e.getMessage());
            
        } finally {
            // This block is always executed
            System.out.println("Program executed successfully!");
        }
    }
}





// You are using Java
import java.util.Scanner;

// Custom exception for invalid hours
class InvalidHourException extends Exception {
    public InvalidHourException(String message) {
        super(message);
    }
}

// Custom exception for invalid minutes
class InvalidMinuteException extends Exception {
    public InvalidMinuteException(String message) {
        super(message);
    }
}

// Custom exception for invalid seconds
class InvalidSecondsException extends Exception {
    public InvalidSecondsException(String message) {
        super(message);
    }
}

public class Main {

    public static void validateTime(int hours, int minutes, int seconds)
            throws InvalidHourException, InvalidMinuteException, InvalidSecondsException {
        if (hours > 12) {
            throw new InvalidHourException("Exception occurred: InvalidHourException - hour is greater than 24");
        }
        if (minutes > 60) {
            throw new InvalidMinuteException("Exception occurred: InvalidMinuteException - minute is greater than 60");
        }
        if (seconds > 60) {
            throw new InvalidSecondsException("Exception occurred: InvalidSecondsException - second is greater than 60");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read hours, minutes, and seconds input from the user
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();
        int seconds = scanner.nextInt();

        try {
        
            validateTime(hours, minutes, seconds);
            
          ime
            System.out.printf("Correct Time - %02d:%02d:%02d\n", hours, minutes, seconds);
        } catch (InvalidHourException | InvalidMinuteException | InvalidSecondsException e) {
         
            System.out.println(e.getMessage());
        }
    }
}



// Queency wants to write a program to validate the email address and display suitable exceptions if there is a mistake.



// Create 3 custom exception classes as below

// DotException
// AtTheRateException
// DomainException


// A typical email address should have a " . " or "@" character, and the domain name should be valid. Valid domain names for practice are 'in', 'com', 'net', or 'biz'.



// Display an Invalid Dot usage, Invalid @ usage, or Invalid Domain message based on the email ID.



// Get the email address from the user, validate the email by checking the above-mentioned criteria, and print the validity status of the input email address.

// Input format :
// The input consists of a string representing the email to be validated.

// Output format :
// If the email is valid, print "Valid email address".

// If there is a dot exception, print "DotException: Invalid Dot usage", followed by "Invalid email address".

// If there is a rate exception, print "AtTheRateException: Invalid @ usage", followed by "Invalid email address".

// If there is a domain exception, print "DomainException: Invalid Domain", followed by "Invalid email address".



// Refer to the sample output for the formatting specifications.

// Sample test cases :
// Input 1 :
// sample@gmail.com
// Output 1 :
// Valid email address
// Input 2 :
// sample@gmail.com.
// Output 2 :
// DotException: Invalid Dot usage
// Invalid email address
// Input 3 :
// sample@g@mail.com
// Output 3 :
// AtTheRateException: Invalid @ usage
// Invalid email address
// Input 4 :
// sample@gmail.con
// Output 4 :
// DomainException: Invalid Domain
// Invalid email address
