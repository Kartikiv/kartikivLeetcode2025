class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (sMap[sc] != tMap[tc]) {
                return false;
            }

            if (sMap[sc] == 0) {
                sMap[sc] = i + 1;
                tMap[tc] = i + 1;
            }
        }

        return true;
    }
}