
import Solution2.Solution.Trie;

public class Main {

    public static void main(String[] args) {
        Trie dictionary = new Trie();
        String sentence = "aadsfasf absbs bbab cadsfafs";
        String[] dict = { "a", "b", "c" };

        for (String word : dict) {
            dictionary.insert(word);
        }
        dictionary.genAll();
        System.out.println(dictionary.swapAll(sentence));
    }
};