class Solution {
    List<HashMap<Integer, Integer>> ans = new ArrayList<>();
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n ;
        
        for(int j = 0 ; j < n ; j++){
            HashMap<Integer,Integer> current = new HashMap<>();
            boolean [] canVisit  = new boolean[n];
            boolean[] diag1 = new boolean[2*n];
            boolean[] diag2 = new boolean[2*n];
            int id1 = 0 - j + (n - 1);
            int id2 = 0 + j;
            Arrays.fill(canVisit, true);
            Arrays.fill(diag1, true);
            Arrays.fill(diag2, true);
            current.put(0,j);
            canVisit[j] = diag1[id1] = diag2[id2] = false;
            helper(current, 1, j, 1, canVisit, diag1, diag2);
        }
            System.out.println(ans);
    return  getBoard(ans);}

    public void helper(HashMap<Integer,Integer> current, int index , int prevJ, int count, boolean [] canVisit,boolean[] diag1,boolean[] diag2){
        if (count == n) {
            ans.add(new HashMap<>(current));
        }
        if ( index > n){
            return;
        }
        for(int j = 0; j < n ; j++){
            int id1 = index - j + (n - 1);
            int id2 = index + j;
            if ( canVisit[j] && diag1[id1] && diag2[id2] ){
                current.put(index, j);
                canVisit[j] = diag1[id1] = diag2[id2] = false;
                count++;
                helper(current, index + 1, j, count, canVisit,diag1, diag2);
              canVisit[j] = diag1[id1] = diag2[id2]  = true;
                current.remove(index);
                count--;
            }
        }
        

    }
    public List<List<String>> getBoard(List<HashMap<Integer, Integer>> ans){
        List<List<String>> board = new ArrayList<>();
        for(HashMap<Integer, Integer> map : ans){
            List<String> row = new ArrayList<>();
            for(int i = 0 ; i < n; i++){
                StringBuilder sb = new StringBuilder(".".repeat(n));
                sb.setCharAt(map.get(i), 'Q');
                row.add(sb.toString());
            }
            board.add(row);


        }
   return board; }
    
}