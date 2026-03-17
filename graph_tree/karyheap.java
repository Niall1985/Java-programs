import java.util.*;

public class KaryHeap{
  static ArrayList<Integer>heap = new ArrayList<>();
  
  static void heapifyUp(int i, int k){
    while(i > 0){
      int parent = (i-1)/k;
      if(heap.get(parent) > heap.get(i)){
        swap(parent, i);
        i = parent;
      }
      else break;
    }
  }
  
  static void heapifyDown(int i, int k){
    int smallest = i;
    for(int j = 1 ; j <= k ; j++){
      int child = k * i + j;
      
      if(child < heap.size() && heap.get(child) < heap.get(smallest)){
        smallest = child;
      }
    }
    if(smallest != i){
      swap(i, smallest);
      heapifyDown(smallest, k);
    }
  }
  
  static void insert(int val, int k){
    heap.add(val);
    heapifyUp(heap.size() - 1, k);
  }
  
  static int peekMin(){
    if(heap.isEmpty()) return -1;
    return heap.get(0);
  }
  
  static int extractMin(int k){
    if(heap.isEmpty()) return -1;
    int min = heap.get(0);
    heap.set(0, heap.get(heap.size() - 1));
    heap.remove(heap.size() - 1);
    heapifyDown(0, k);
    return min;
  }
  
  static int extractMax(){
    if(heap.isEmpty()) return -1;
    int maxIndex = 0;
    for(int i = 1 ; i < heap.size() ; i++){
      if(heap.get(i) > heap.get(maxIndex)){
        maxIndex = i;
      }
    }
    int max = heap.get(maxIndex);
    heap.remove(maxIndex);
    return max;
  }
  static void swap(int i, int j) {
    int temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }
  
  public static void main(String[] args) {
    int k = 3;
    insert(10, k);
    insert(4, k);
    insert(15, k);
    insert(20, k);
    insert(0, k);
    insert(8, k);
    System.out.println("Heap: " + heap);
    System.out.println("Min: " + peekMin());
    System.out.println("Extract Min: " + extractMin(k));
    System.out.println("Heap after extractMin: " + heap);
    System.out.println("Extract Max: " + extractMax());
    System.out.println("Heap after extractMax: " + heap);
  }
}
