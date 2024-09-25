// You are using Java
import java.util.Scanner;
    public class Main{
        void convertBase(String str, int b1, int b2){
            boolean check = false;
            for(int i = 0; i<str.length(); i++){
                if(!Character.isDigit(str.charAt(i))){
                    check = true;
                    break;
                }   
            }
            
            if(check){
                System.out.printf("Invalid input.");
                return;
            }
            else if((b1<2 || b1>32 || b2<2 || b2>32)){
                System.out.printf("Invalid base.");
                return; 
            }
            
            else{
                int nu1 = Integer.valueOf(str);
                int num = Math.abs(nu1);
                if(num<0){
                    System.out.printf("Invalid");
                }
                else{
            //Binary to decimal
            if(b1 == 2 && b2 == 10){
                int temp = num;
                int count = 0;
                int sum = 0;
                while(temp != 0){
                    int d = temp%10;
                    int p = (int) Math.pow(2,count);
                    sum += p*d;
                    count++;
                    temp /= 10;
                }
                System.out.printf("%d",sum);
            }
            
            //binary to hexadecimal
            else if(b1 == 2 && b2 == 16){
                int temp1 = num;
                int count1 = 0;
                int sum1 = 0;
                while(temp1 != 0){
                    int d1 = temp1%10;
                    int p1 = (int) Math.pow(2,count1);
                    sum1 += p1*d1;
                    count1++;
                    temp1 /= 10;
                }
                System.out.print(Integer.toHexString(sum1));
            }
            //binary to octal
            else if(b1 == 2 && b2 == 8){
                int temp1 = num;
                int count1 = 0;
                int sum1 = 0;
                while(temp1 != 0){
                    int d1 = temp1%10;
                    int p1 = (int) Math.pow(2,count1);
                    sum1 += p1*d1;
                    count1++;
                    temp1 /= 10;
                }
                System.out.print(Integer.toOctalString(sum1));
            }
            
            //dec to bin
            else if(b1 == 10 & b2 == 2){
                System.out.print(Integer.toBinaryString(num));
            }
            
            // dec to octal
            else if(b1 == 10 & b2 == 8){
                System.out.print(Integer.toOctalString(num));
            }
            //dec to hex
            else if(b1 == 10 & b2 == 2){
                System.out.print(Integer.toHexString(num));
            }
        }
            
            
            }
        }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String sr = s.next();
        int b1 = s.nextInt();
        int b2 = s.nextInt();
        Main m = new Main();
        m.convertBase(sr,b1,b2);
    }
}
