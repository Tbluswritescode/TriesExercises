
import Solution3.Solution.Trie;

public class Main {

    public static void main(String[] args) {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        Trie wordsTrie = new Trie();

        for (String w : words) {
            wordsTrie.insert(w);
        }
        System.out.println(wordsTrie.getLong());
    }
};