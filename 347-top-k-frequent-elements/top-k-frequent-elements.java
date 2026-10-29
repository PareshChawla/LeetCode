//Brute force O(nlogn) , next optimize it to O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int element: nums) {
            if(freq.containsKey(element)) {
                freq.put(element, freq.get(element) + 1);
            } else {
                freq.put(element, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());

        entries.sort((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
     return result;
    }
}