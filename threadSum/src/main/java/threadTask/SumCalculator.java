package threadTask;

import java.util.List;

/**
 * Created by Graffit on 22.12.2016.
 */
public class SumCalculator extends Thread {
    private List<Integer> array;
    private int startIndex;
    private int endIndex;
    private int sum;

    public SumCalculator(List<Integer> array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run(){
        sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += array.get(i);
        }
    }

    public int getSum() {
        return sum;
    }
}
