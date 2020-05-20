package Week06;
import java.util.*;

class ArrayData {
    ArrayList<Integer> list;
    int cycles;
    ArrayList<ArrayList<Integer> > cycleList;
    double time;

    public ArrayData(ArrayList<Integer> list, int cycles, ArrayList<ArrayList<Integer> > cycleList, double time) {
        this.list = list;
        this.cycles = cycles;
        this.cycleList = cycleList;
        this.time = time;
    }

    public int getCycles() {
        return this.cycles;
    }

    public int getCycleMaxLength() {
        int maxLength = Integer.MIN_VALUE;
        for (ArrayList<Integer> list : this.cycleList) {
            if (list.size() >= maxLength) {
                maxLength = list.size();
            }
        }
        return maxLength;
    }

    public int getCycleMinLength() {
        int minLength = Integer.MAX_VALUE;
        for (ArrayList<Integer> list : this.cycleList) {
            if (list.size() <= minLength) {
                minLength = list.size();
            }
        }
        return minLength;
    }

    public double getTime() {
        return this.time;
    }
}