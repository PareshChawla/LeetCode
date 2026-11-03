class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                long sum = (long) nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                }
                else if (sum > 0) {
                    right--;
                }
                else {
                    result.add(Arrays.asList(
                        nums[i], nums[left], nums[right]
                    ));

                    // Remember the values before moving pointers
                    int a = nums[left];
                    int b = nums[right];

                    left++;
                    right--;

                    // Skip duplicate left values
                    while (left < right && nums[left] == a) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right && nums[right] == b) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}