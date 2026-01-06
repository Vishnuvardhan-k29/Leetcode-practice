import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> table = new HashMap<>();
        for (String word : arr) {
            char[] temp = word.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            table.putIfAbsent(key, new ArrayList<>());
            table.get(key).add(word);
        }
        return new ArrayList<>(table.values());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = sol.groupAnagrams(words);
        System.out.println(result);
    }
}