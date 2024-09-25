import java.util.Scanner;

public class Main{
  
  void check(String s){
    for(int i = 0 ; i < s.length(); i++){
      char current = s.charAt(i);
      boolean isTrue = false;
      
      for(int j = 0 ; j < i ; j++){
        if(s.charAt(j) == current){
          isTrue = true;
          break;
        }
      }
      
      if(!isTrue){
        System.out.print(current);
      }
    }
  }
  
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    String str = s.nextLine();
    Main m = new Main();
      m.check(str);
  }
}
