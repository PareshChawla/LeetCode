class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int[] subArr = new int[26];
        List<Integer> result = new ArrayList<>();
        for(char c: p.toCharArray()) {
            subArr[c - 'a']++;
        }
        int left = 0;
        int[] bigArr = new int[26];
        for(int right = 0; right < s.length(); right++) {
            bigArr[s.charAt(right) - 'a']++;
            if(right - left + 1 > k) {
                bigArr[s.charAt(left) - 'a']--;
                left++;
            }
            if(right - left + 1 == k) {
                if(Arrays.equals(subArr, bigArr)) {
                    result.add(left);
                }
            }
        }
        return result;
    }
}