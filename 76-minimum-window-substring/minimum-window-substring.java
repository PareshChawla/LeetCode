class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int[] targetFreq = new int[128];
        int[] windowFreq = new int[128];
        int formed = 0;
        int required = t.length();
        for(char c: t.toCharArray()) {
            targetFreq[c]++;
        }
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowFreq[c]++;
            if(windowFreq[c] <= targetFreq[c]) {
                formed++;
            }
            while(formed==required) {
                int windowLength = right - left + 1;
                if(windowLength < minLength) {
                    minLength = windowLength;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                if(windowFreq[leftChar] <= targetFreq[leftChar]) {
                    formed--;
                }
                windowFreq[leftChar]--;
                left++;
            }         
        }
        return minLength==Integer.MAX_VALUE? "": s.substring(startIndex, startIndex+minLength);
    }
}