import java.util.Scanner;

class Student{
  public String name;
  public int age;
  Student(String name, int age){
    this.name = name;
    this.age = age;
  }
}

class Person extends Student{
  public String dob;
  Person(String name, int age, String dob){
    super(name, age);
    this.dob = dob;
  }
  
  void display(){
    System.out.printf("%s\n%d\n%s\n", name, age, dob);
    System.out.printf("\n");
  }
}

public class Main{
  public static void main(String[] args){
    Person[] p = new Person[3];
    p[0] = new Person("Niall", 18, "03-12-2005");
    p[1] = new Person("Niall", 18, "03-12-2005");
    p[2] = new Person("Niall", 18, "03-12-2005");
    for(int i = 0 ; i < 3 ; i++){
      p[i].display();
    }
  }
}









import java.util.Scanner;

class ClothingItem{
    String name;
    double price;
    int quantity;
    
    ClothingItem(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    double getPrice(){
        return price;
    }
    
    int getQuantity(){
        return quantity;
    }
    
    public static double calculateGrossWorth(ClothingItem[] items){
        double grossWorth = 0;
        for(ClothingItem item : items){
            grossWorth += item.getPrice() * item.getQuantity();
        }
        return grossWorth;
    }
    
    public static double calculateNetWorth(ClothingItem[] items){
        double netWorth = 0;
        for(ClothingItem item : items){
            double val = item.getPrice() * item.getQuantity();
            double discount = 0;
            if(val > 50.00){
                discount = val*0.10;
            }
            else if(item.getQuantity() > 10){
                discount = val*0.15;
            }
            else if(val <= 50.00 && item.getQuantity() > 5){
                discount = val*0.05;
            }
            netWorth += val - discount;
        }
        return netWorth;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfItems = scanner.nextInt();

        ClothingItem[] items = new ClothingItem[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            String name = scanner.nextLine();
            scanner.nextLine();
            double price = scanner.nextDouble();
            int quantity = scanner.nextInt();

            items[i] = new ClothingItem(name, price, quantity);
        }

        double grossWorth = ClothingItem.calculateGrossWorth(items);
        double netWorth = ClothingItem.calculateNetWorth(items);

        System.out.printf("%.2f%n", grossWorth);
        System.out.printf("%.2f", netWorth);
    }
}
