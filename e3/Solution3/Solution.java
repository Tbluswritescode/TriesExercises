package Solution3;

import java.util.List;
import java.util.*;

public class Solution {

    public static class Trie {
        Map<Character, Trie> kids = new HashMap<>();
        boolean isWord = false;
        String longSoFar = "";


        public Trie() {

        }
        public void insertAll(String[] words){
            Set<String> wordSet = new HashSet<String>(Arrays.asList(words));
            System.out.println(wordSet);
            for (String w : wordSet){
                insert(w);
            }
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

        public List<String> getAll() {
            List<String> results = new LinkedList<>();
            getAllHelp("", results);
            return results;
        }

        public String getLong() {
            ArrayList<String> fullPaths = new ArrayList<String>();
            String lon = "";
            int lonCount = 0;
            for (Map.Entry<Character, Trie> e : this.kids.entrySet()){
                System.out.println(e.getValue());
                if (e.getValue().isWord){
                    lon += e.getKey();
                    lon += Longest(e.getValue(), "" );
                    System.out.println(lon);
                    if (lon.length() >= lonCount){
                        lonCount = lon.length();
                        fullPaths.add(lon);
                    }
                    
                    lon = "";
                }
            }
            Collections.sort(fullPaths);
            for (String pth : fullPaths){
                if (pth.length() == lonCount){
                    return pth;
                }
            }
            System.out.println(fullPaths);
            return lon;
        }

        public String Longest(Trie next, String longest) {
            if (next.kids.entrySet().iterator().hasNext()) {
                Map.Entry<Character, Trie> entry = next.kids.entrySet().iterator().next();
                if (entry.getValue().isWord && next.kids.entrySet().iterator().hasNext()) {
                    longest += entry.getKey();
                    next = entry.getValue();
                    longest = Longest(next, longest);
                }else if (entry.getValue().isWord){
                    return longest += entry.getKey(); 
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
