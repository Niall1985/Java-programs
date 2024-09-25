//Using this. , super. , super()

import java.util.Scanner;

class Speed{
  public double distance;
  public double time;
  Speed(double distance, double time){
    this.distance = distance;
    this.time = time;
  }
  void display(){
    double speed = distance/time;
    System.out.printf("Speed: %.2f ", speed);
  }
}

class Model extends Speed{
  public String model;
  Model(double distance, double time, String model){
    super(distance, time);
    this.model = model;
  }
  @Override
  void display(){
    super.display();
    System.out.printf("Model: %s", model);
  }
}
public class Main{
  public static void main(String[] args){
    Model m = new Model(120.0, 2.5, "Volvo");
    m.display();
  }
}
