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
