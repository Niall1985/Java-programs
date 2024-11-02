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




// Single File Programming Question
// Problem Statement



// Cindy is working on a text processing program, and she needs your help. The program is designed to replace all vowels in a given text with a specified consonant. 



// Create a file named file1.txt and prompt the user to input a text. Write the user's input into file1.txt. Then, read the content and perform a specific logic (replacing vowels with a consonant provided by the user), and write the modified result into a new file named file2.txt. Lastly, display the modified result obtained from file2.txt. 

// Input format :
// The first line of input consists of a string, representing the text that needs vowel replacement.

// The second line is a single character value, representing the consonant to replace the vowels with.

// Output format :
// The output displays the string representing the modified text after replacing the vowels with the specified consonant.



// Refer to the sample output for the formatting specifications.

// Code constraints :
// The string contains lowercase and uppercase with at most 80 characters.

// Sample test cases :
// Input 1 :
// Hello World
// X
// Output 1 :
// HXllX WXrld
// Input 2 :
// Programming is fun
// y
// Output 2 :
// Prygrymmyng ys fyn
// Input 3 :
// Apple
// r
// Output 3 :
// rpplr




import java.util.Scanner;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String sent = s.nextLine();
        char character = s.next().charAt(0);
        StringBuilder modifiedString = new StringBuilder();
        for(int i = 0 ; i < sent.length() ; i++){
            
            char ch = sent.charAt(i);
            if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || 
            ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                modifiedString.append(character);
            }
            else{
                modifiedString.append(ch);
            }
        }
        System.out.printf("%s", modifiedString);
    }
}


//serialization

// You are using Java
import java.util.Scanner;
import java.io.*;

class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    public int age;
    
    public Person(int age){
        this.age = age;
    }
    
    public int getage(){
        return age;
    }
    
    public String getagegroup(){
        if(age>=0 && age<=12){
            return "Kid";
        }
        else if(age>=13 && age<=19){
            return "Teen";
        }
        else if(age>=20){
            return "Adult";
        }
        return null;
    }
}

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int age = s.nextInt();
        Person person = new Person(age);
        try(FileOutputStream fileout = new FileOutputStream("Person.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileout)){
            out.writeObject(person);
        } catch(IOException e){
            e.printStackTrace();
        }
        
        try(FileInputStream fileIn = new FileInputStream("Person.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn)){
            Person deserializedPerson = (Person) in.readObject();
            System.out.println(deserializedPerson.getagegroup());
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
