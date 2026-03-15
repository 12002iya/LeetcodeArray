package heap;

import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        System.out.println(pq.peek());

    }
}
