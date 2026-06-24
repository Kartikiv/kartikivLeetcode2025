class Solution {
    public int strStr(String haystack, String needle) {
        int [] lps = constructLps(needle);
        int i = 0; 
        int j = 0; 
        List<Integer> ansAllMatchingIndex = new ArrayList<>();
        while(i < haystack.length()){ 
            if(needle.charAt(j) == haystack.charAt(i)){ 
                i++; 
                j++;
            }else{ 
                if(j == 0){ 
                    i++;
                }else{ 
                    j = lps[j - 1];
                }
            }
            if(j == needle.length()){ 
                ansAllMatchingIndex.add(i - needle.length());
                j = 0;
            }
        }
        return ansAllMatchingIndex.isEmpty()? -1 : ansAllMatchingIndex.get(0);
    }

    public int[] constructLps(String needle) {
        int previousLps = 0;
        int lengthNeedle = needle.length();
        int[] lps = new int[lengthNeedle];
        int i = 1;
        while (i < lengthNeedle) {
            // if the character's are equal
            char needleChar = needle.charAt(i);
            char previousLpsChar = needle.charAt(previousLps);
            if (needleChar == previousLpsChar) {
                lps[i] = previousLps + 1;
                previousLps++;
                i++;
            } else if (previousLps == 0) {
                lps[i] = 0;
                i++;
            } else {
                previousLps = lps[previousLps - 1];
            }

        }
        return lps;
    }
}