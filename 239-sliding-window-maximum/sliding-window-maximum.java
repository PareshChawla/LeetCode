class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for(int right = 0; right < nums.length; right++) {
            if(!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            if(right >= k - 1) {
                result[right-k+1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}