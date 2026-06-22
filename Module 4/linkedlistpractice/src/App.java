/*
    Module 4.2 Assignment by Noah McCarthy
    Create a linked list of 50,000 and 500,000 integers and look at the difference in time it takes to find an index using different methods.

    My Observations:
    The results both were similar in speed with 50,000 integers, but iterator clears at 500,000 integers.
    The iterator method is much more efficent in comparison to the .get() method.
    The .get() method worked for smaller amounts as the delay was less noticable, but it forces the computer to do more work causing it 
    to take longer to find the index. I think it took a whole minute longer to find the index with .get() compared to iterator. 


    */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> bigList = new LinkedList<>();
         for (int i = 0; i < 50000; i++) {
            list.add(i);
        }
        for (int i = 0; i < 500000; i++) {
            bigList.add(i);
        }
       System.out.println("What number in the list do you want to find?");
       int search = scanner.nextInt();
       iteratorSearch(list, search);
       ListGet(list, search);
       System.out.println("What number in the list do you want to find?");
       search = scanner.nextInt();

       iteratorSearch(bigList, search);
       ListGet(bigList, search);
    }

    public static void iteratorSearch(LinkedList<Integer> list, int search) {
        System.out.println("Using an iterator, lets see how long it takes...");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
           int value = iterator.next();
           if (value == search) {
               System.out.println("Found the number: " + value);
               break;
           }
       }
    }


    public static void ListGet(LinkedList<Integer> list, int search) {
        System.out.println("Now using get index, lets see how long it takes...");
        for (Integer i : list) {
            if (list.get(i) == search) {
               System.out.println("Found the number: " + list.get(i));
               break;
           }
        }
    }
}
