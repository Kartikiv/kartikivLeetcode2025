class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;

        // vector for length = 2
        // first m entries: up[i]   = arrays ending at value i where last move was up
        // next  m entries: down[i] = arrays ending at value i where last move was down
        long[] vec = new long[size];

        for (int i = 0; i < m; i++) {
            vec[i] = i;                 // previous value < i
            vec[m + i] = m - 1 - i;     // previous value > i
        }

        if (n == 2) {
            return sum(vec);
        }

        long[][] trans = new long[size][size];

        for (int curr = 0; curr < m; curr++) {
            // newUp[curr] = sum of oldDown[prev] where prev < curr
            for (int prev = 0; prev < curr; prev++) {
                trans[curr][m + prev] = 1;
            }

            // newDown[curr] = sum of oldUp[prev] where prev > curr
            for (int prev = curr + 1; prev < m; prev++) {
                trans[m + curr][prev] = 1;
            }
        }

        long power = n - 2L;

        while (power > 0) {
            if ((power & 1) == 1) {
                vec = multiplyMatrixVector(trans, vec);
            }

            trans = multiplyMatrix(trans, trans);
            power >>= 1;
        }

        return sum(vec);
    }

    private long[] multiplyMatrixVector(long[][] mat, long[] vec) {
        int n = vec.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long total = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0 && vec[j] != 0) {
                    total = (total + mat[i][j] * vec[j]) % MOD;
                }
            }

            res[i] = total;
        }

        return res;
    }

    private long[][] multiplyMatrix(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }

    private int sum(long[] vec) {
        long ans = 0;

        for (long x : vec) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }
}