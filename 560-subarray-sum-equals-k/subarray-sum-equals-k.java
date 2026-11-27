
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map =
            new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            int requiredPrefix = prefixSum - k;

            count += map.getOrDefault(
                requiredPrefix, 0
            );

            map.put(
                prefixSum,
                map.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }
}
