/* we need to keep track of the previous number so that if we encounter a large number be subtract and add */
class Solution {
    public int romanToInt(String s) {
      HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int prev = 0;
        int ans = 0;
        for (char c : s.toCharArray()){
            int current = map.get(c);
            if(prev != 0 && prev < current){
                ans = ans + (current - 2 * prev);
            }else{
            ans += current;
            }
            prev = current;
        }

    return ans; }
}