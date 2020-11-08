package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    public static void main(String[] args) {
        Average avg = new Average(3);
        System.out.println("Average till now is " + avg.next(1));
        System.out.println("Average till now is " + avg.next(10));
        System.out.println("Average till now is " + avg.next(3));
        System.out.println("Average till now is " + avg.next(5));
    }
}
class Average{
    private Queue<Integer> queue;
    private int maxSize;
    private double sum;
    public Average(int size){
        queue = new LinkedList<>();
        maxSize = size;
        sum = 0.0;
    }

    public double next(int val){
        if(queue.size() == maxSize){
            sum -= queue.remove();
        }
        queue.add(val);
        sum += val;
        return sum/queue.size();
    }

}
