class Solution {
    static final long BASE = 31;
    static final long MOD = 1_000_000_007;

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;
        if (n < m) return -1;

        long needleHash = 0;
        long windowHash = 0;
        long power = 1;

        // power = BASE^(m - 1)
        for (int i = 0; i < m - 1; i++) {
            power = (power * BASE) % MOD;
        }

        // initial hashes
        for (int i = 0; i < m; i++) {
            needleHash = (needleHash * BASE + needle.charAt(i)) % MOD;
            windowHash = (windowHash * BASE + haystack.charAt(i)) % MOD;
        }

        for (int i = 0; i <= n - m; i++) {
            if (windowHash == needleHash) {
                
                    return i;
                
            }

            if (i < n - m) {
                char leftChar = haystack.charAt(i);
                char rightChar = haystack.charAt(i + m);

                windowHash = windowHash - (leftChar * power) % MOD;
                if (windowHash < 0) {
                    windowHash += MOD;
                }

                windowHash = (windowHash * BASE + rightChar) % MOD;
            }
        }

        return -1;
    }

    private boolean matches(String haystack, String needle, int start) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(start + i) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}