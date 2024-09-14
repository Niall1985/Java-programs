// You are using Java
import java.util.Scanner;
import java.util.*;

class PalindromeChecker{
    public int num;
    public boolean isPalindrome = false;
    PalindromeChecker(int num){
        this.num = num;
        
    }
    
    void isPalindrome(){
        int temp = num;
        int rev = 0;
        do{
            int d = temp%10;
            rev = rev*10 + d;
            temp /= 10;
        }
        while(temp != 0);
        if(rev == num){
            isPalindrome = true;
        }
    }
    
    void displayResult(){
        if(isPalindrome){
            System.out.printf("The number is a palindrome.\n");
        }
        else{
            System.out.printf("The number is not a palindrome.\n");
        }
    }
}


class WordPalindromeChecker extends PalindromeChecker{
    public String str;
    public boolean isPalindrome = false;
    WordPalindromeChecker(String str){
        super(0);
        this.str = str;
    }
    
    @Override
    void isPalindrome(){
        String original = str.toLowerCase();
        String rev = new StringBuilder(str).reverse().toString();
        
        if(rev.equals(original)){
            isPalindrome = true;
        }
    }
    
    @Override
    void displayResult(){
        if(isPalindrome){
            System.out.printf("The word is a palindrome.\n");
        }
        else{
            System.out.printf("The word is not a palindrome.\n");
        }
    }
}



public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        s.nextLine();
        String str = s.nextLine();
        
        
        PalindromeChecker p = new PalindromeChecker(n);
        p.isPalindrome();
        p.displayResult();
        WordPalindromeChecker ptr = new WordPalindromeChecker(str.toLowerCase());
        ptr.isPalindrome();
        ptr.displayResult();
    }
}



// Problem Statement



// Janani aims to create a versatile palindrome checker capable of handling both numeric values and words. 



// The base class, PalindromeChecker, features a parameterized constructor that takes an integer as input. It includes a method, isPalindrome(), which determines whether the given integer is a palindrome. Include a method displayResult() to print the result of the palindrome check for numbers.



// The subclass, WordPalindromeChecker, is derived from the base class. This subclass overrides the isPalindrome() method to accommodate word inputs, treating them case-insensitively. The overridden displayResult() method ensures that the outcome of the word palindrome check is appropriately printed.



// Create instances of both classes in the main class and display the results.

// Input format :
// The first line of input consists of an integer.

// The second line consists of a string, it contains lowercase and uppercase letters with spaces.

// Output format :
// If the given integer is a palindrome, the first line of output prints "The number is a palindrome."

// Else, print "The number is not a palindrome."

// If the given string is a palindrome, the second line of output prints "The word is a palindrome."

// Else, print "The word is not a palindrome."



// Refer to the sample output for formatting specifications.

// Code constraints :
// 1 ≤ input integer ≤ 109

// length of string < 50

// The strings are case-insensitive.

// Sample test cases :
// Input 1 :
// 121
// madam
// Output 1 :
// The number is a palindrome.
// The word is a palindrome.
// Input 2 :
// 15651
// raar world
// Output 2 :
// The number is a palindrome.
// The word is not a palindrome.
// Input 3 :
// 1563
// Malayalam
// Output 3 :
// The number is not a palindrome.
// The word is a palindrome.
// Input 4 :
// 45789
// java
// Output 4 :
// The number is not a palindrome.
// The word is not a palindrome.
// Input 5 :
// 1
// race
// Output 5 :
// The number is a palindrome.
// The word is not a palindrome.

