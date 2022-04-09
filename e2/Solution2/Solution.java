package Solution2;

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

        private String getMatch(String word) {
            for (String w : allWords) {
                if (word.startsWith(w)) {
                    return w;
                }
            }
            return word;
        }

        public String swapAll(String sentence) {
            String[] words = sentence.split(" ");
            String finalString = "";
            for (String word : words) {
                finalString += getMatch(word) + " ";
            }
            return finalString.trim();
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