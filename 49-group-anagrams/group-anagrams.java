class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word: strs) {
            int[] arr = new int[26];
            for(int i = 0; i < word.length(); i++) {
                arr[word.charAt(i)- 'a']++;
            }
            StringBuilder freq = new StringBuilder();
            for(int c: arr) {
                freq.append('#').append(c);
            }
            String signature = freq.toString();
            map.computeIfAbsent(signature, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}