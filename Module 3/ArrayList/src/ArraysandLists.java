/* Modulee 3.2 Assignment by Noah McCarthy
Create a randomized arraylist and create a method that takes an arraylist of anytype and removes duplicated from it.
 */


import java.util.*;

public class ArraysandLists {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> intarrayList = new ArrayList<>();
        ArrayList<Double> doublearrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            intarrayList.add( (int)((Math.random() * 20) + 1)); //cast math random to int so I can actually see if it works and not get tons of decimals 
            doublearrayList.add(((Math.random() * 20) + 1));
        }
        intarrayList.sort(null); // make it easier to read output
        doublearrayList.sort(null); // make it easier to read output
        System.out.println("Original Randomized int ArrayList:");
        System.out.println(intarrayList);
        System.out.println("ArrayList with Duplicates Removed:");
        System.out.println(removeDuplicates(intarrayList));

        System.out.println("Original Randomized double ArrayList:");
        System.out.println(doublearrayList);
        System.out.println("ArrayList with Duplicates Removed:");
        System.out.println(removeDuplicates(doublearrayList));
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();
        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
            newList.sort(null); // make it easier to read output
        }
        return newList;
    }
}
