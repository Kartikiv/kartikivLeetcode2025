/* 
Here we know that a unique solution exists to the problem and also 
we know that the problem cannot be solved if total gas <= total cost as there
is not enough gas to cover the cost so, if (total(gas) >= total(cost) we can say a solution exist and they told that the solution is unique)
Therefore since we know that a solution exists we can then compute the diffence array of gas to cost and say that at what every position we start and till the end if the total sum never reaches zero then that postion must be the solution 
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (total(gas) < total(cost))
            return -1;
        int total = 0;
        int ans = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] = gas[i] - cost[i];
            total += gas[i];
            if (total < 0) {
                total = 0;
                ans = i + 1;
            }

        }
        return ans;
    }

    public int total(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}