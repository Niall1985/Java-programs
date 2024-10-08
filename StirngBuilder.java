// You are using Java
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        StringBuilder sbl = new StringBuilder(str);
        sbl.reverse();
        String reversed = sbl.toString();
        System.out.printf("%s", reversed);
    }
}





import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder wordBuilder = new StringBuilder(word);
            result.append(wordBuilder.reverse().toString()).append(" ");
        }

        String output = result.toString().trim();
    
        System.out.println(output);
    }
}





// You are using Java
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        int index = s.nextInt();
        if(index<0 || index > str1.length()){
            System.out.printf("Invalid position.");
        }
        else{
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(index, str2);
            System.out.println(sb.toString().trim());
        }
    }
}






// You are using Java
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        StringBuilder sb = new StringBuilder();
        for(char ch : input.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }
        System.out.printf(sb.toString());
    }
}





// You are using Java
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





// You are using Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
  
        Scanner scanner = new Scanner(System.in);
        
     
        String input = scanner.nextLine();
        
        StringBuilder uniqueChars = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            if (uniqueChars.indexOf(String.valueOf(currentChar)) == -1) {
                uniqueChars.append(currentChar);
            }
        }
    
        System.out.println(uniqueChars.toString());
        

        scanner.close();
    }
}




import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dateString1 = scanner.next();
        LocalDate date1 = parseDate(dateString1);

        String dateString2 = scanner.next();
        LocalDate date2 = parseDate(dateString2);

        long daysDifference = calculateDaysDifference(date1, date2);

        System.out.println(daysDifference + " days");

        scanner.close();
    }

    private static LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }

    private static long calculateDaysDifference(LocalDate date1, LocalDate date2) {
        return Math.abs(date1.toEpochDay() - date2.toEpochDay());
    }
}
