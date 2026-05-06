import java.util.*;

class Node{
  int data;
  Node next, prev;
  
  Node(int data){
    this.data = data;
    prev = next = null;
  }
}

public class Main{
  Node head;
  void insert(int data){
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
    newNode.prev = temp;
  }
  
  void display(){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data + " <-> ");
      temp = temp.next;
    }
    System.out.println("null");
  }
  
  int []toArray(){
    int count = 0;
    Node temp = head;
    while(temp != null){
      count++;
      temp = temp.next;
    }
    
    int[]arr = new int[count];
    temp = head;
    int i = 0;
    while(temp != null){
      arr[i++] = temp.data;
      temp = temp.next;
    }
    return arr;
  }
  
  public static void main(String[] args){
    Main list = new Main();
    list.insert(10);
    list.insert(20);
    list.insert(30);
    list.display();
    
    int[] arr = list.toArray();
    for(int x : arr){
      System.out.print(x + " ");
    }
  }
}
