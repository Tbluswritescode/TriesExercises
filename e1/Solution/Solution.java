package Solution;

import java.util.*;

public class Solution {

    public static class Trie {
        Map<Character, Trie> kids = new HashMap<>();
        boolean isWord = false;
        String lon = "";
        String shortest = "lllxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        public Trie() {

        }

        public void insert(String word, String fullword) {
            if (word.length() == 0) {
                isWord = true;
            } else {
                char first = word.charAt(0);
                String rest = word.substring(1);

                if (!kids.containsKey(first)) {
                    kids.put(first, new Trie());
                }

                kids.get(first).insert(rest, fullword);
            }
            if (fullword.length() < shortest.length()) {
                shortest = fullword;
            }
        }

        public String getLong() {
            getLongHelper(this);
            return lon;
        }

        private void getLongHelper(Trie next) {
            Map.Entry<Character, Trie> entry;
            if (!isWord && next.kids.entrySet().iterator().hasNext()) {
                entry = next.kids.entrySet().iterator().next();
                if (next.kids.size() < 2 && lon.length() < shortest.length()) {
                    lon += entry.getKey();
                    next = entry.getValue();
                    getLongHelper(next);
                }
            }
        }

        // private char getChar() {
        // return kids.keySet().iterator().next();
        // }

        public List<String> getAll() {
            List<String> results = new LinkedList<>();
            getAllHelp("", results);
            return results;
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