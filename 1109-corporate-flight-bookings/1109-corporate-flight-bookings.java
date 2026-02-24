class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int[] book : bookings) {
            ans[book[0] - 1] += book[2];
            int end = book[1];
            if (end < n)
                ans[end] -= book[2];
        }
        int run = 0;
        for (int i = 0; i < ans.length; i++) {
            run += ans[i];
            ans[i] = run;
        }

        return ans;
    }
}