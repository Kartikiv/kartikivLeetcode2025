class Solution {
    List<String> ans = new ArrayList<>();
    HashMap<Character, Character[]> charMap;
    char[] digitArray;

    public List<String> letterCombinations(String digits) {
        this.digitArray = digits.toCharArray();
        setMap();
        StringBuilder current = new StringBuilder();
        helper(0, current);
        return ans;
    }

    public void setMap() {
        HashMap<Character, Character[]> charMap = new HashMap<>();
        charMap.put('2', new Character[] { 'a', 'b', 'c' });
        charMap.put('3', new Character[] { 'd', 'e', 'f' });
        charMap.put('4', new Character[] { 'g', 'h', 'i' });
        charMap.put('5', new Character[] { 'j', 'k', 'l' });
        charMap.put('6', new Character[] { 'm', 'n', 'o' });
        charMap.put('7', new Character[] { 'p', 'q', 'r','s' });
        charMap.put('8', new Character[] { 't', 'u', 'v' });
        charMap.put('9', new Character[] { 'w', 'x', 'y', 'z' });
        this.charMap = charMap;

    }

    public void helper(int index, StringBuilder current) {
        if (index == digitArray.length) {
            ans.add(current.toString());
            return;
        }

        for (char c : charMap.get(digitArray[index])) {
            current.append(c);
            helper(index + 1, current);
            current.deleteCharAt(current.length() - 1);

        }

    }
}