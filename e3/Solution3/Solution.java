package Solution3;

import java.util.*;

public class Solution {

    public static class Trie {
        Map<Character, Trie> kids = new HashMap<>();
        boolean isWord = false;
        List<String> allWords;

        public Trie() {

        }

        public void insert(String word) {
            if (word.length() == 0) {
                isWord = true;
            } else {
                char first = word.charAt(0);
                String rest = word.substring(1);

                if (!kids.containsKey(first)) {
                    kids.put(first, new Trie());
                }

                kids.get(first).insert(rest);
            }
        }

        public void genAll() {
            allWords = getAll();
        }

        public List<String> getAll() {
            List<String> results = new LinkedList<>();
            getAllHelp("", results);
            return results;
        }

        public String getLong() {
            return Longest(this, "");
        }

        public String Longest(Trie next, String longest) {
            if (next.kids.entrySet().iterator().hasNext()) {
                Map.Entry<Character, Trie> entry = next.kids.entrySet().iterator().next();
                if (entry.getValue().isWord) {
                    longest += entry.getKey();
                    next = entry.getValue();
                    System.out.println(longest);
                    longest = Longest(next, longest);
                }
            }
            return longest;
        }

        private void getAllHelp(String path, List<String> results) {
            if (isWord) {
                results.add(path);
            }
            for (Map.Entry<Character, Trie> entry : kids.entrySet()) {
                char ch = entry.getKey();
                Trie child = entry.getValue();
                child.getAllHelp(path + ch, results);
            }
        }
    }
}