import java.util.Scanner;

interface NumberInput{
    int getInput();
}

interface AutomorphicChecker{
    boolean isAutomorphic(int n);
}

class AutomorphicNumber implements NumberInput, AutomorphicChecker{
    private int number;
    @Override
    public int getInput(){
        Scanner s = new Scanner(System.in);
        number = s.nextInt();
        return number;
    }
    
    @Override
    public boolean isAutomorphic(int n){
        int square = n*n;
        String numStr = Integer.toString(n);
        String sqrStr = Integer.toString(square);
        return sqrStr.endsWith(numStr);
    }
    
    public void display(){
        if(isAutomorphic(number)){
            System.out.printf("%d is an automorphic number", number);
        }
        else{
            System.out.printf("%d is not an automorphic number", number);
        }
    }
}


public class Main{
    public static void main(String[] args){
        AutomorphicNumber an = new AutomorphicNumber();
        int n = an.getInput();
        an.display();
    }
}
