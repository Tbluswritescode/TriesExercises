import java.util.Map;
import java.util.HashMap;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie longestCommon = new Trie();
        for (String s : strs) {
            longestCommon.insert(s, s);
        }
        return longestCommon.getLong();
    }

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
                System.out.println(shortest.length());
                System.out.println(shortest);
                if (next.kids.size() < 2 && lon.length() < shortest.length()) {
                    lon += entry.getKey();
                    next = entry.getValue();
                    getLongHelper(next);
                }
            }
        }
    }
};
