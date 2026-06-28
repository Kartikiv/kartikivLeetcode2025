class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> freMap = new HashMap<>(); 
        for(int num: nums){ 
            freMap.put(num, freMap.getOrDefault(num, 0) + 1);
        }
        int maxCount = 1; 
        for(int i = nums.length - 1; i >= 0; i--){ 
            // pick a number and go down 
            int count = 1; 
            int num = nums[i];
            while(num >= 4){ 
                int sqrtNum = (int) Math.sqrt(num);
                if(sqrtNum * sqrtNum != num) break;
                if(freMap.getOrDefault(sqrtNum, 0) >= 2){ 
                    count += 2;
                }else{
                    break;
                }
                num = sqrtNum;

                maxCount = Math.max(count, maxCount);

            }
        }
        maxCount = Math.max(maxCount, freMap.getOrDefault(1, 0));
    return maxCount % 2 == 0 ? maxCount - 1 : maxCount;}
}