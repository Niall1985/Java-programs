import java.util.*;

class Node{
  int data;
  Node next;
  
  Node(int data){
    this.data = data;
    this.next = null;
  }
}

class LinkedList{
  Node head;
  
  void add(int data){
    Node newNode = new Node(data);
    if(head == null){
      head = newNode;
      return;
    }
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.next = newNode;
  }
  
  void display(){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }
  
  void detectLoop(){
    Node slow = head;
    Node fast = head;
    Boolean flag = false;
    while(slow != null && fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        flag = true;
        break;
      }
    }
    if(flag){
      System.out.println("Loop found " + slow.data);
    }
    else{
      System.out.println("No Loop found ");
    }
  }
  
  void createLoop(int pos) {
    if (pos < 0) return;
    Node loopNode = null;
    Node temp = head;
    int index = 0;
    while (temp.next != null) {
        if (index == pos) {
            loopNode = temp;
        }
        temp = temp.next;
        index++;
    }
    if (index == pos) {
        loopNode = temp;
    }
    if (loopNode != null) {
        temp.next = loopNode; 
    }
  }
}
public class Main {
    public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.add(10);
      list.add(20);
      list.add(30);
      list.add(40);
      
      list.display();
      list.createLoop(1);
      list.detectLoop();
  }
}
