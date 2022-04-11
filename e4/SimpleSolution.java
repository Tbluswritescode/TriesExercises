
import java.util.HashMap;

public class SimpleSolution {

    public class MapSum {
        /*
         * This solution does not use a trie but is apparently faster than 74% of
         * submitted answers
         */
        private HashMap<String, Integer> mapsum = new HashMap<String, Integer>();

        public MapSum() {
        }

        public void insert(String key, int val) {
            mapsum.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (String e : mapsum.keySet()) {
                if (e.startsWith(prefix)) {
                    if (mapsum.get(e) != null) {
                        sum += (int) mapsum.get(e);
                    }
                }
            }
            return sum;
        }
    }
}
