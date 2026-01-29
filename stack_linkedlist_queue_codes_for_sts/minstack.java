import java.util.*;

class MinStack{
  Stack<Integer>stack = new Stack<>();
  Stack<Integer>minstack = new Stack<>();
  
  void push(int x){
    stack.push(x);
    if(minstack.isEmpty() || x <= minstack.peek()){
      minstack.push(x);
    }
  }
  
  void pop(){
    if(stack.pop().equals(minstack.peek())){
      minstack.pop();
    }
  }
  int top(){
    return stack.peek();
  }
  int getmin(){
    return minstack.peek();
  }
}
public class Main {
    public static void main(String[] args) {
      MinStack ms = new MinStack();
      ms.push(5);
      ms.push(3);
      ms.push(7);
      ms.push(2);
      int min = ms.getmin();
      System.out.println("Min before pop: " + min);
      ms.pop();
      min = ms.getmin();
      System.out.println("Min after pop: " + min);
  }
}
