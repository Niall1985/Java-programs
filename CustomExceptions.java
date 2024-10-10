// You are using Java
import java.util.Scanner;

class MyException extends Exception{
    public MyException(String str){
        super(str);
    }
}

class ZeroException extends Exception{
    public ZeroException(String message){
        super(message);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        try{
            int n = s.nextInt();
            if(n>0 && n<7){
                System.out.printf("%d", n);
            }
            else{
                if(n>=7){
                    throw new MyException("Caught a custom exception: Input must be less than 7");
                }
                else if(n == 0){
                    throw new ZeroException("Caught a custom exception: Cannot divide by zero");
                }
            }
        }
        catch(MyException e){
            System.out.println(e.getMessage());
        }
        catch (ZeroException e){
            System.out.println(e.getMessage());
        }
    }
}
