class Solution {
    static final long BASE = 31;
    static final long MOD = 1_000_000_007;

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;
        if (n < m) return -1;

        long hashNeedle = hashString(needle);
        long hashHaystack = hashString(haystack.substring(0, m));

        long power = 1;
        for (int i = 0; i < m - 1; i++) {
            power = (power * BASE) % MOD;
        }

        for (int i = 0; i <= n - m; i++) {
            if (hashHaystack == hashNeedle) {
                if (haystack.substring(i, i + m).equals(needle)) {
                    return i;
                }
            }

            if (i < n - m) {
                char leftChar = haystack.charAt(i);
                char rightChar = haystack.charAt(i + m);

                hashHaystack = hashHaystack - (leftChar * power) % MOD;

                if (hashHaystack < 0) {
                    hashHaystack += MOD;
                }

                hashHaystack = (hashHaystack * BASE + rightChar) % MOD;
            }
        }

        return -1;
    }

    public long hashString(String s) {
        long hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash = (hash * BASE + s.charAt(i)) % MOD;
        }

        return hash;
    }
}