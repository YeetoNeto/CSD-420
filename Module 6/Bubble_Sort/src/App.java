/*
Module 6.2 Assignment by Noah McCarthy
I created a class that implements comparable and a basic class that comparator can use within the program

*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        //Comparable Test
        System.out.println("========= Comparable Test =========");
        ArrayList<Bubble_Numbers_Comparable> bubble_comparable = new ArrayList<Bubble_Numbers_Comparable>();
        //Add random numbers and make like 10 values in the list
        for (int i = 0; i < 10; i++) {
            bubble_comparable.add(new Bubble_Numbers_Comparable((int) (Math.random() * 100)));
        }
        //print array before
        System.out.println("Array before sorting:");
        System.out.println(bubble_comparable);
        System.out.println();
        for (int i = 0; i < bubble_comparable.size(); i++) {
            for (int j = 0; j < bubble_comparable.size() - 1 - i; j++) {
                if (bubble_comparable.get(j).compareTo(bubble_comparable.get(j + 1)) > 0) {
                    Bubble_Numbers_Comparable temp = bubble_comparable.get(j);
                    bubble_comparable.set(j, bubble_comparable.get(j + 1));
                    bubble_comparable.set(j + 1, temp);
                }
            }
        }
        //print array after
        System.out.println("Array after sorting:");
        System.out.println(bubble_comparable);
        System.out.println();


        //Comparator Test
        System.out.println("========= Comparator Test =========");
        ArrayList<Bubble_Numbers> bubble_comparator = new ArrayList<Bubble_Numbers>();
        //Add random numbers and make like 10 values in the list
        for (int i = 0; i < 10; i++) {
            bubble_comparator.add(new Bubble_Numbers((int) (Math.random() * 100)));
        }
        Comparator<Bubble_Numbers> comparator = (v1, v2) -> Integer.compare(v1.getValue(), v2.getValue());
        //print array before
        System.out.println("Array before sorting:");
        System.out.println(bubble_comparator);
        System.out.println();
        for (int i = 0; i < bubble_comparator.size(); i++) {
            for (int j = 0; j < bubble_comparator.size() - 1 - i; j++) {
                if (comparator.compare(bubble_comparator.get(j), bubble_comparator.get(j + 1)) > 0) {
                    Bubble_Numbers temp = bubble_comparator.get(j);
                    bubble_comparator.set(j, bubble_comparator.get(j + 1));
                    bubble_comparator.set(j + 1, temp);
                }
            }
        }
        //print array after
        System.out.println("Array after sorting:");
        System.out.println(bubble_comparator);
        System.out.println();
    }
}
