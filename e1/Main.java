import Solution.Solution.Trie;

public class Main {
    public static void main(String[] args) {
        String[] newStrings = { "Hello", "Hellfire", "Hemorage" };
        String[] shorts = { "ab", "a" };
        String[] similar = { "Saturday", "Saturn", "Saturate", "Saturity" };
        String[][] arrs = { newStrings, shorts, similar };
        for (String[] strs : arrs) {

            // copy following two 4 lines (to end of 4) into longestCommonPrefix(String[]
            // strs) and end with Return longestCommon.getLong()
            // See third file for final solution committed to LeetcodeS
            Trie longestCommon = new Trie();
            for (String s : strs) {
                longestCommon.insert(s, s);
            }
            System.out.println("longest commom subsequence of array" + strs + "  " + longestCommon.getLong());
        }
    }
}
