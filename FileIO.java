// Problem Statement
// Amy is tasked with creating a program that manages book details by storing them in files. 
// The program should allow users to input book details such as title, author, and publisher, and then store this information in a file named sourcefile.txt. Once the details are stored, the program should copy the content from sourcefile.txt to another file named destinationfile.txt and display the copied content to the user.

// Your task is to help Amy in writing the program to accomplish her task.

// Input format :
// The first line of input consists of a string representing the book's title.

// The second line consists of a string representing the author's name.

// The third line consists of a string representing the publisher's name.

// Output format :
// If the details are successfully written to the file, the first line of output prints "Content copied to destinationfile.txt successfully!"

// The second line prints "Book Details:"

// The third line prints "Title: " followed by a string representing the book's title.

// The fourth line prints "Author: " followed by a string representing the author's name.

// The fifth line prints "Publisher: " followed by a string representing the publisher's name.



// Refer to the sample output for formatting specifications.

// Code constraints :
// 1 ≤ Length of the String ≤ 50

// Sample test cases :
// Input 1 :
// Java Programming
// John Doe
// ABC Publications
// Output 1 :
// Content copied to destinationfile.txt successfully!
// Book Details:
// Title: Java Programming
// Author: John Doe
// Publisher: ABC Publications
// Input 2 :
// Introduction to Algorithms
// Thomas H. Cormen
// MIT Press
// Output 2 :
// Content copied to destinationfile.txt successfully!
// Book Details:
// Title: Introduction to Algorithms
// Author: Thomas H. Cormen
// Publisher: MIT Press


import java.util.Scanner;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        String title = s.nextLine();
        String author = s.nextLine();
        String publisher = s.nextLine();
        
        try(FileWriter writer = new FileWriter("sourcefile.txt")){
            writer.write(title + "\n" + author + "\n" + publisher);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        StringBuilder titleNew = new StringBuilder();
        StringBuilder authorNew = new StringBuilder();
        StringBuilder publisherNew = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader("sourcefile.txt"))){
            titleNew.append(reader.readLine());
            authorNew.append(reader.readLine());
            publisherNew.append(reader.readLine());
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        try(FileWriter writer = new FileWriter("destinationfile.txt")){
            writer.write(titleNew + "\n" + authorNew + "\n" + publisherNew);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        System.out.printf("Content copied to destinationfile.txt successfully!\n");
        System.out.printf("Book Details:\n");
        System.out.printf("Title: %s\n", titleNew);
        System.out.printf("Author: %s\n", authorNew);
        System.out.printf("Publisher: %s\n", publisherNew);
        
    }
}
