package Week06;
import java.util.*;
import java.io.*;

class CountCycles {

    // Create a list of elements from 0 to listSize-1
    public static ArrayList<Integer> createList(int listSize) {
        ArrayList<Integer> list = new ArrayList<Integer>();
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
    
    public static void runExperiments(int lists, int listSizeMin, int listSizeMax) {
        int counter = 0;
        System.out.print("id,list_size,cycles,time,max_cycle_length,min_cycle_length\n");
        for (int i = listSizeMin; i < listSizeMax + 1; i++) {
            for (int j = 0; j < lists; j++ ) {
                ArrayList<Integer> list = createList(i);
                list = shuffleList(list);
                ArrayData arrayData = countCycles(list);
                System.out.print(counter + ",");
                System.out.print(i + ",");
                System.out.print(arrayData.getCycles() + ",");
                System.out.print(arrayData.getTime() + ",");
                System.out.print(arrayData.getCycleMaxLength() + ",");
                System.out.print(arrayData.getCycleMinLength() + "\n");
                counter += 1;
            }
        }
    }

    // Count the number of cycles in the input list, that has been shuffled
    public static ArrayData countCycles(ArrayList<Integer> list) {
        long startTime = System.nanoTime();
        Set<Integer> intSet = new HashSet<>();
        // Create a set containing elements: "0,...,n-1"
        for (int i = 0; i < list.size(); i++) {
            intSet.add(i);
        }
        int cycleCounter = 0;
        ArrayList<ArrayList<Integer> > cycleList = new ArrayList<ArrayList<Integer> >();
        // Make sure we visit all elements in the set of "n" elements 
        while (!intSet.isEmpty()) {
            ArrayList<Integer> cycle = new  ArrayList<Integer>();
            Iterator<Integer> iterator = intSet.iterator();
            int index = iterator.next(); int indexCopy = index;
            // Remove the visited element from the set
            intSet.remove(index); cycle.add(index);
            // Get the next element given an index 
            index = list.get(index);
            while (index != indexCopy) {
                // Remove visited element from the set
                intSet.remove(index); cycle.add(index);
                index = list.get(index);
            }
            cycleCounter += 1;
            cycleList.add(cycle);
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000.0;
        ArrayData arrayData = new ArrayData(list, cycleCounter, cycleList, duration);
        return arrayData;
    }

    public static void main(String[] args) {
        int lists = 0;
        int listSizeMin = 0;
        int listSizeMax = 0;
        if (args.length > 0) {
            try {
                lists = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[0] + " must be an integer.");
                System.exit(1);
            }
            try {
                listSizeMin = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[1] + " must be an integer.");
                System.exit(1);
            }
            try {
                listSizeMax = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[2] + " must be an integer.");
                System.exit(1);
            }
            if (lists != 0 && listSizeMin != 0 && listSizeMax != 0) {
                runExperiments(lists, listSizeMin, listSizeMax);
            }
        }
    }
}