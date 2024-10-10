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
