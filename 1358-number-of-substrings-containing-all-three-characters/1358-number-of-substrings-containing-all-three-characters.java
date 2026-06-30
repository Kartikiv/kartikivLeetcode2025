class Solution {
    public int numberOfSubstrings(String s) {
        // native way check all substring from the begining character 
        int countSubstring = 0;
        int firstA = -1;
        int firstB = -1;
        int firstC = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int lastChar = 0;
            if (s.charAt(i) == 'a') {
                firstA = i;
                lastChar = firstB == -1 || firstC == -1 ? -1 : Math.max(firstB, firstC);
            } else if (s.charAt(i) == 'b') {
                firstB = i;
                lastChar = firstA == -1 || firstC == -1 ? -1 : Math.max(firstA, firstC);
            } else if (s.charAt(i) == 'c') {
                firstC = i;
                lastChar = firstB == -1 || firstA == -1 ? -1 : Math.max(firstB, firstA);
            }

            if (lastChar != -1) {
                countSubstring += s.length() - lastChar;
            }

        }
        return countSubstring;
    }

    public boolean checkContains(int[] arr) {
        for (int num : arr) {
            if (num < 1)
                return false;
        }
        return true;
    }
}