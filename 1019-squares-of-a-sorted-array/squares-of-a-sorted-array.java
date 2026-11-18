class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        while(left <= right) {
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];
            if(leftSqr > rightSqr) {
                result[index] = leftSqr;
                left++;
            } else {
                result[index] = rightSqr;
                right--;
            }
            index--;
        }
        return result;
    }
}