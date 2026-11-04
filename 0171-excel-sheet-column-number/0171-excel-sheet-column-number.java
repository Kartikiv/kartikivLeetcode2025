
class Solution {
    public int titleToNumber(String columnTitle) {
        int colNum = 0;
        int ordinal = 1;

        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            colNum += (columnTitle.charAt(i) - 'A' + 1) * ordinal;
            ordinal *= 26;
        }

        return colNum;
    }
}
