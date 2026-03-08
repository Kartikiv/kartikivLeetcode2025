import java.util.*;

class Solution {
    List<String> ans;

    public List<String> letterCombinations(String digits) {
        this.ans = new ArrayList<>();
        
        List<Character>[] charMapping = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            charMapping[i] = new ArrayList<>();
        }
        charMapping[2].addAll(Arrays.asList('a', 'b', 'c'));
        charMapping[3].addAll(Arrays.asList('d', 'e', 'f'));
        charMapping[4].addAll(Arrays.asList('g', 'h', 'i'));
        charMapping[5].addAll(Arrays.asList('j', 'k', 'l'));
        charMapping[6].addAll(Arrays.asList('m', 'n', 'o'));
        charMapping[7].addAll(Arrays.asList('p', 'q', 'r', 's'));
        charMapping[8].addAll(Arrays.asList('t', 'u', 'v'));
        charMapping[9].addAll(Arrays.asList('w', 'x', 'y', 'z'));

        dfs(digits.toCharArray(), charMapping, new StringBuilder(), 0);
        return ans;
    }

    void dfs(char[] digits, List<Character>[] charMapping, StringBuilder sb, int i) {
        if (i == digits.length) {
            ans.add(sb.toString());
            return;
        }
            char c = digits[i];
            for (Character ch : charMapping[c - '0']) {
                sb.append(ch);
                dfs(digits, charMapping, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        
    }
}