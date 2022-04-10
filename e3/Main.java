
import Solution3.Solution.Trie;

public class Main {

    public static void main(String[] args) {
        String[] words = {"o","a","ajd","ajdpw","ojowj","okpnd","okpn","ef","oetj","ajdp","ojo","o","ok","oet","o","oj","ojowjy","e"};
        Trie wordsTrie = new Trie();

        wordsTrie.insertAll(words);
        System.out.println(wordsTrie.getLong());
    }
}