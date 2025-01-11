import java.util.ArrayDeque;
import java.util.Deque;

public class Maximum_of_all_subarrays_of_size_k {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ri = 0;
        int r[] = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                r[ri++] = nums[dq.peek()];
            }
        }

        return r;
    }
}
