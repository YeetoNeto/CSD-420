/*
Module Assignment 5.2 by Noah McCarthy
Read data and modify it by removing duplicates, and sorting in ascending and descending order
*/


import java.io.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        String filePath = System.getProperty("user.dir") + "\\src\\collection_of_words.txt"; // set a file path variable that can easily be changed
        ArrayList<String> wordList = new ArrayList<>();
       try {
        BufferedReader fr = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = fr.readLine()) != null){
            wordList.add(line);  //search till end of file
        }
        fr.close(); //close file 
       } catch (FileNotFoundException e) { // error catch
        System.out.println("File not found");
       }
      System.out.println("The list of words is: " + wordList);
      HashSet<String> setList = new HashSet<>(wordList); //convert to hashset to remove duplicates
      System.out.println("The list of words without duplicates is: " + setList);
      Collections.sort(wordList); // ascending order sort
      System.out.println("The sorted list of words, in ascending order, is: " + wordList);
      Collections.reverse(wordList); // descending order sort
      System.out.println("The sorted list of words, in descending order, is: " + wordList);
    }
}
