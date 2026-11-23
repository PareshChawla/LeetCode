class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int p = s2.length();
        if(k > p) return false;
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];
        for(char c: s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }
        int left = 0;
        for(int right = 0; right < p; right++) {
            windowFreq[s2.charAt(right) - 'a']++;
            if(right - left + 1 > k) {
                windowFreq[s2.charAt(left) - 'a']--;
                left++;
            }
            if(right - left + 1 == k) {
                if(Arrays.equals(s1Freq, windowFreq)) {
                    return true;
                }
            }
        }
        return false;
    }
}