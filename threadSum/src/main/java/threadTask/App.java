package threadTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final int THREAD_COUNT = 4;
    private static final int ELEMENT_COUNT = 10000;

    public static void main( String[] args ) throws InterruptedException
    {
        int totalSum = 0;

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < ELEMENT_COUNT; i++) {
            list.add(1);
        }

        SumCalculator[] threads = new SumCalculator[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new SumCalculator(list, ELEMENT_COUNT/THREAD_COUNT * i,
                    i == THREAD_COUNT - 1 ? ELEMENT_COUNT : ELEMENT_COUNT/THREAD_COUNT * (i+1));
            threads[i].start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].join();
            totalSum += threads[i].getSum();
            System.out.println("thread [" + i + "] sum : " + threads[i].getSum());
        }
        System.out.println("sumtotal: " + totalSum);
    }

}
