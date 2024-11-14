import java.util.Scanner;
import java.util.*;

class InvalidDotUsage extends Exception{
    public InvalidDotUsage(String message){
        super(message);
    }
}

class InvalidAtTheRateUsage extends Exception{
    public InvalidAtTheRateUsage(String message){
        super(message);
    }
}

class InvalidDomainName extends Exception{
    public InvalidDomainName(String message){
        super(message);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        try{
            String email = s.next();
            if(!email.matches("[^@]+@[^@]+")){
                throw new InvalidAtTheRateUsage("Invalid usage of @\nInvalid email");
            }
            if(!email.matches("[^@]+@[^@]+\\..+")){
                throw new InvalidDotUsage("Invalid dot usage\nInvalid email");
            }
            if(!email.matches(".*\\.(in|com|net|biz)")){
                throw new InvalidDomainName("Invalid domain name\nInvalid email");
            }
            System.out.printf("Email is valid\n");
        }
        catch(InvalidDotUsage e){
            System.out.println(e.getMessage());
        }
        catch(InvalidAtTheRateUsage e){
            System.out.println(e.getMessage());
        }
        catch(InvalidDomainName e){
            System.out.println(e.getMessage());
        }
    }
}
