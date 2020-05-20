package Week06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.io.*;

public class ShuffleLists {
    
    // Create a list of elements from 0 to listSize -1 
    public static ArrayList<Integer> createList(int listSize) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(i);
        }
        return list;
    }

    // Shuffle the given list of elements
    public static ArrayList<Integer> shuffleList(ArrayList<Integer> list) {
        Collections.shuffle(list);
        return list;
    }

    public static void printShuffledLists(int lists, int listSizeMax) {
        int counter = 0;
        for (int j = 0; j < lists; j++) {
            ArrayList<Integer> list = createList(listSizeMax);
            list = shuffleList(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int lists = 0;
        int listSizeMax = 0;
        if (args.length > 0) {
            try {
                lists = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[1] + " must be an integer.");
                System.exit(1);
            }
            if (lists != 0 && listSizeMax != 0) {
                printShuffledLists(lists, listSizeMax);

            }
        }

    }
}
