class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] arr = new int[26];
        int maxLength = 0;
        int maxFreq = 0;
        for(int right = 0; right < s.length(); right++) {
            arr[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, arr[s.charAt(right) - 'A']);
            while((right - left + 1) - maxFreq > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}