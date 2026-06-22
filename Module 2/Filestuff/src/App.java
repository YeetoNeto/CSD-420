/*
Module Assignment 2.2 06/14/2026
Create and read files
*/

import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] randomInt = new int[5];
        double[] randomDouble = new double[5];

        System.out.println(System.getProperty("user.dir"));
        System.out.println("Hello, World!");
        System.out.println("Crunching numbers....");

        for (int i = 0; i < 5; i++) {
            randomInt[i] = (int) (Math.random() * 100);
            randomDouble[i] = Math.random() * 100;
        }

        System.out.println("Numbers crunched, writing to file...");

        //Use printwriter with a fileoutputstream that allows appending and creates a new file if not already there
        try (PrintWriter output = new PrintWriter(new FileOutputStream("NoahMcCarthy_datafile.dat", true))) {
            output.println("Random Integers: ");
            for (int i : randomInt) {               
                output.println(i);
            }
            output.println("Random Doubles: ");
            for (double d : randomDouble) {
                output.println(d);
            }
        } catch (FileNotFoundException e) { // this isn't needed, but just put it there for good measure
            System.out.println("File not found: ");
        }
        System.out.println("Data written to file, Enjoy!");
    }
}
