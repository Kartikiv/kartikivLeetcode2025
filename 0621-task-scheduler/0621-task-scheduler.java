class task{
char a;
int frequency;
int time;
public task(char a, int frequency, int time ){
    this.a = a;
    this.frequency = frequency;
    

}
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int ans = 0;
        int [] freq = new int [26];
        for (char task : tasks){
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int frequency : freq){
            if(frequency > 0){
                pq.offer(frequency);
            }
        }
        while(!pq.isEmpty()){
        List<Integer> pending = new ArrayList<>();
        int executeInCycle = 0;
            for(int i = 0 ;!pq.isEmpty() && i  <= n ; i++){
            int frequency = pq.poll();
            frequency--;
            executeInCycle++;
            
            if(frequency > 0){
                pending.add(frequency);
            }
            }
            ans += executeInCycle;
            pq.addAll(pending);
           
            
            if(!pq.isEmpty() && executeInCycle < n + 1){
                ans = ans + (n + 1) - executeInCycle;
               
            }
        }   
    return ans; }
}