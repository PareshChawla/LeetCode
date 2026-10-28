class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String word: strs) {
            int[] count = new int[26];
            for(int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int c: count) {
            key.append('#').append(c);
            }
            String signature = key.toString();
            if(groups.containsKey(signature)) {
                groups.get(signature).add(word);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(word);
                groups.put(signature, newGroup);
            }
        }
        return new ArrayList<>(groups.values());
    }
}