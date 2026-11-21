class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < nums.length; right++) {
            // Expand the window by adding the right element
            currentSum += nums[right];

            // Shrink the window from the left while the sum is valid (>= target)
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength was never updated, no valid subarray exists
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
