class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        row.add(1);
        if(rowIndex == 0) return row;
        row.add(1);
        for (int i = 0; i < rowIndex - 1; i++) {
        List<Integer> tempRow = new ArrayList<>();
        tempRow.add(1);
            for(int j =1; j < row.size(); j++){
                tempRow.add(row.get(j) + row.get(j - 1));
            }
            tempRow.add(1);
            row = tempRow;
        }
    return row;}
}