// You are using Java
import java.util.Scanner;


abstract class Course{
    public int duration;
    public int assignments;
    public double costperweek;
    public int weeklystudyhours;
    
    abstract int getTotalHours(int weeklystudyhours);
    abstract int getNumberOfAssignments();
    abstract double getEstimatedCost();
}

class DataScienceCourse extends Course{
    public int duration;
    public int assignments;
    public double costperweek;
    // public int weeklystudyhours;
    
    DataScienceCourse(int duration, int assignments, double costperweek){
        this.duration = duration;
        this.assignments = assignments;
        this.costperweek = costperweek;
    }
    
    @Override
    int getTotalHours(int weeklystudyhours){
        this.weeklystudyhours = weeklystudyhours;
        return duration*weeklystudyhours;
    }
    
    @Override
    int getNumberOfAssignments(){
        return duration*assignments;
    }
    
    @Override
    double getEstimatedCost(){
        return duration * costperweek;
    }
}



class AIandMLCourse extends Course{
    public int duration;
    public int assignments;
    public double costperweek;
    // public int weeklystudyhours;
    
    AIandMLCourse(int duration, int assignments, double costperweek){
        this.duration = duration;
        this.assignments = assignments;
        this.costperweek = costperweek;
    }
    
    @Override
    int getTotalHours(int weeklystudyhours){
        this.weeklystudyhours = weeklystudyhours;
        return duration*weeklystudyhours;
    }
    
    @Override
    int getNumberOfAssignments(){
        return duration*assignments;
    }
    
    @Override
    double getEstimatedCost(){
        return duration * costperweek;
    }
}

class CybersecurityCourse extends Course{
    public int duration;
    public int assignments;
    public double costperweek;
    // public int weeklystudyhours;
    
    CybersecurityCourse(int duration, int assignments, double costperweek){
        this.duration = duration;
        this.assignments = assignments;
        this.costperweek = costperweek;
    }
    
    @Override
     int getTotalHours(int weeklystudyhours){
        this.weeklystudyhours = weeklystudyhours;
        return duration*weeklystudyhours;
    }
    
    @Override
    int getNumberOfAssignments(){
        return duration*assignments;
    }
    
    @Override
    double getEstimatedCost(){
        return duration * costperweek;
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int courseType = scanner.nextInt();
        int duration = scanner.nextInt();
        int assignmentsPerWeek = scanner.nextInt();
        double costPerWeek = scanner.nextDouble();
 
        Course course;
 
        switch (courseType) {
            case 1:
                course = new DataScienceCourse(duration, assignmentsPerWeek, costPerWeek);
                break;
            case 2:
                course = new AIandMLCourse(duration, assignmentsPerWeek, costPerWeek);
                break;
            case 3:
                course = new CybersecurityCourse(duration, assignmentsPerWeek, costPerWeek);
                break;
            default:
                System.out.println("Invalid course type selected");
                scanner.close();
                return;
        }
 
        int weeklyHours = scanner.nextInt();
 
        int totalHours = course.getTotalHours(weeklyHours);
        int numberOfAssignments = course.getNumberOfAssignments();
        double estimatedCost = course.getEstimatedCost();
 
        System.out.printf("The course duration is %d weeks%n", duration);
        System.out.printf("Total study hours: %d hours%n", totalHours);
        System.out.printf("Number of assignments: %d%n", numberOfAssignments);
        System.out.printf("Estimated cost: Rs. %.2f%n", estimatedCost);
 
        scanner.close();
    }
}
