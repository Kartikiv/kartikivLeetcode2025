class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[]  sMap = getSignature(s);
        int [] tMap = getSignature(t);

        for(int i = 0 ; i < s.length(); i++){
            if(sMap[s.charAt(i)] != tMap[t.charAt(i)]){
                return false;
            }
        }
        return true;
    }

    int[] getSignature(String s) {
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 0)
                map[s.charAt(i)] = i + 1;

        }
        return map;
    }
}