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
            if(map.containsKey(signature)) {
                map.get(signature).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(signature, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}