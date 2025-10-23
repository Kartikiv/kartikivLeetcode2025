class Solution {
    HashMap<Integer,Integer> positionSpeedMap = new HashMap<>();
    public boolean  checkCollide (int pos1, int pos2, int target){
            return (double)(target - pos1) / positionSpeedMap.get(pos1) <= (double)(target - pos2) / positionSpeedMap.get(pos2) ;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        
        for (int i = 0 ; i < position.length ; i++ ){
            positionSpeedMap.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        Stack < Integer> stack = new Stack<>();
        for (int i = position.length - 1; i >= 0 ; i-- ){
            if (!stack.isEmpty() &&  checkCollide(position[i], stack.peek(), target)) {
                
            } 
            else{ 
                stack.add(position[i]);
            }             

        }

        return stack.size(); 
    }

}