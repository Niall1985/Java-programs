import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String startDateString = scanner.nextLine();
    
        String endDateString = scanner.nextLine();
        
        try {
    
            LocalDate startDate = LocalDate.parse(startDateString, dateFormatter);
            LocalDate endDate = LocalDate.parse(endDateString, dateFormatter);
            
            // Calculate the difference in days
            long daysDifference = java.time.Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay()).toDays();
            
            // Output the difference
            System.out.printf("%d days%n", Math.abs(daysDifference)); // Use Math.abs() to ensure positive output
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use 'yyyy-mm-dd'.");
        } finally {
            scanner.close();
        }
    }
}
