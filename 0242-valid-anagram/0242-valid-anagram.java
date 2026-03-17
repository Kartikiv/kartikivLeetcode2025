class Solution {
  public static boolean isAnagram(String s, String t) {
    // anagram are words with same character and frequency but there are jumbbled
    // For example dog , god there are anagram
    // Simple approach is check with two arrays on 26 length and return if all the
    // elements are zero
    // so only one array of 26 is enough
    int[] charArr = new int[26];
    if (s.length() != t.length())
      return false;
    for (int i = 0; i < s.length(); i++) {
      charArr[s.charAt(i) - 'a']++;
      charArr[t.charAt(i) - 'a']--;
    }

    for (int num : charArr) {
      if (num != 0)
        return false;
    }

    return true;
  }

  public static void main(String [] args){
    System.out.println(isAnagram("anagram","nagaram"));
  }
}
