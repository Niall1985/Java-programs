//Method1
import java.util.Scanner;

public class Main {

    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int calculateLCM(int[] numbers) {
        int lcm = 1;
        for (int num : numbers) {
            lcm = (lcm * num) / calculateGCD(lcm, num);
        }
        return lcm;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int lcm = calculateLCM(numbers);

        System.out.println(lcm);
    }
}

//Method2
// You are using Java
import java.util.Scanner;
    public class Main{
        int calculateLCM(int[] arr){
            int lcm = 1;
            int divisor = 2;
            while(true){
                boolean divisible = false;
                boolean allOne = true;
                
                for(int i = 0; i<arr.length; i++){
                    if(arr[i]>1){
                        allOne = false;
                    }
                    if(arr[i]%divisor == 0){
                        arr[i] /= divisor;
                        divisible = true;
                    }
                }
                
                if(!divisible){
                    divisor++;
                }
                else{
                    lcm *= divisor;
            }
            
            if(allOne){
                break;
            }
        }
        return lcm;
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        
        Main m = new Main();
        int res = m.calculateLCM(arr);
        System.out.printf("%d",res);
    }
}
