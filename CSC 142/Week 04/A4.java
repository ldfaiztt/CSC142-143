import java.util.*;
import java.io.*;
/**
 * This program is to ask the user to enter a file name and then analyze the data in the file.
 * This program will do different things to different types of data and show a "File Statistics" at the end.
 * 
 * @author Chun-Wei Chen
 * @version 10/23/11
 */
public class A4 {
  /**
   * Ask the user to enter the file's name, and then use Scanner to read the data from the file.
   */
  public static void main(String[] args) throws FileNotFoundException{
    Scanner console = new Scanner(System.in);
    System.out.print("Please enter a file name or a file path: ");
    String name = console.nextLine();
    File text = new File(name);
    
    // Ask the user to enter the file name again if the file user entered doesn't exist 
    while (!text.canRead()) {
      System.out.println("File not found. Please try again.");
      System.out.print("Please enter a file name or a file path: ");
      text = new File(console.nextLine());
    }
    Scanner input = new Scanner(text);
    
    // Initialize some variables which will be used in "File Statistics"
    int numberEight = 0;
    double lowestDouble = Double.MAX_VALUE;
    int countDouble = 0;
    double sumDouble = 0;
    int numberOfWord = 0;
    int numberOfCharacter = 0;
    
    // Show a message if the file is empty
    if (!input.hasNext())
      System.out.println("This is an empty file.");
    
    // Use while loop to read the file token by token until there is no next token
    while (input.hasNext()) {
      
      // Determine the type of the token
      if (input.hasNextInt()) {
        int num = input.nextInt();
        String convert = "";
        
        // Find out if there is an integer 8 in the file
        if (numberEight == 0 && num == 8)
            numberEight = 1;
        
        // Convert the integer to octal (base-8) if it is greater than 5
        if (num > 5) {
          int num1 = num;
          while (num1 != 0) {
            convert = num1 % 8 + convert;
            num1 /= 8;
          }
          
          System.out.println(num + " in base 10 is equivalent to " + convert + " in octal.");
        }
      }
      
      else if (input.hasNextDouble()) {
        double num = input.nextDouble();
        
        // Find out the lowest double value
        if (num < lowestDouble)
          lowestDouble = num;
        
        // Sum up the double values which are greater than -200 and less than 100 (inclusive) 
        if (num <= 100 && num >= -200) {
          sumDouble += num;
          countDouble++;
        }
      }
       
      else {
        String word = input.next();
        
        // Change the word from file into funny word if the number of vowel of
        // the word is less than or equal to 3  
        if (numberOfVowels(word) <= 3)
          System.out.println(funnyWord(word));
        
        // Count the number of characters in the word
        for (int i = 0; i < word.length(); i++)
          numberOfCharacter++;
        numberOfWord++; // Count the number of words
      }
    }
      
    System.out.println("\nFile Statistics:\n");
    
    // Show the user if integer 8 is in the file or not
    if (numberEight == 1) 
      System.out.println("The number 8 was found!");
    else
      System.out.println("The number 8 was not found.");
    
    // Show the user the lowest and the average of the double value if there is at least 
    // one double value (not include integers which can also be interpreted as double values).
    // Show a meesage if there is no double value in the file.
    if (countDouble > 0) {
      System.out.println("The lowest double value was " + lowestDouble);
      System.out.printf("The average of the double values between -200 and 100 was %.3f\n", 
                        sumDouble / countDouble);
    }
    else
      System.out.println("No double values were found.");
    
    // Show the user how many words and how many characters those words contain in the file.
    System.out.println("The total of " + numberOfWord + " words containing " + numberOfCharacter + " characters were found.");
    System.out.println("That is all!  Goodbye!");
  }
  
  /**
   * Determine if the character is a vowel
   * @param letter a character
   * @return true if the letter is a vowel
   */
  public static boolean isVowel(char letter) {
      return (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' ||
              letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u');
    }
  
  /**
   * Count the number of vowels in the string
   * @param word a string
   * @return the number of vowels in string word
   */
  public static int numberOfVowels(String word) {
    int vowelCount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (isVowel(word.charAt(i)))
        vowelCount++;
    }
    return vowelCount;
  }
  
  /**
   * Create a new funny word from the string passed as a parameter in the following way:
   * if the character is a vowel, copy it three times; otherwise, just repeat it.
   * @param word a string
   * @return the funny word
   */
  public static String funnyWord(String word) {
    String result = "";
    for (int i = 0; i < word.length(); i++) {
      if (isVowel(word.charAt(i))) {
        for (int j = 0; j < 3; j++)
          result += Character.toUpperCase(word.charAt(i));
      }
      else {
        result += word.charAt(i);
      }
    }
    return result;
  }
}