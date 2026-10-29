//O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList(nums.length + 1);
        for(int i = 0; i <= nums.length; i++) {
            buckets.add(null);
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int frequency = entry.getValue();
            if(buckets.get(frequency)==null) {
                buckets.set(frequency, new ArrayList<>());
            }
            buckets.get(frequency).add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for(int f = nums.length; f > 0 && index < k; f--) {
            if(buckets.get(f)==null) {
                continue;
            }
            for(int number: buckets.get(f)) {
                result[index++] = number;
            }
            if(index==k) {
                break;
            }
        }
        return result;
    }
}