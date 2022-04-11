import java.util.Map;
import java.util.HashMap;

/*passed leetcode test*/
/* This solution was significantly slower but also worked. It also employed tries concepts*/
public class MapSum {
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

        private ArrayList<String> getMatch(String start) {
            this.getAll();
            ArrayList<String> strs = new ArrayList<String>();
            for (String w : allWords) {
                if (w.startsWith(start)) {
                    strs.add(w);
                }
            }
            return strs;
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

    private HashMap<String, Integer> mapsum = new HashMap<String, Integer>();
    Trie words = new Trie();

    public MapSum() {
    }

    public void insert(String key, int val) {
        mapsum.put(key, val);
        words.insert(key);
        words.genAll();
    }

    public int sum(String prefix) {
        int sum = 0;
        ArrayList<String> strs = new ArrayList<String>();
        strs = words.getMatch(prefix);
        for (String str : strs) {
            if (mapsum.get(str) != null) {
                sum += (int) mapsum.get(str);
            }
        }
        return sum;
    }
}