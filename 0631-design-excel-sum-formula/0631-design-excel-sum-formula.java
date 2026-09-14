import java.util.*;

class Cell {
    int value;
    boolean isFormula;
    Set<Cell> children;
    HashMap<Cell, Integer> formulaMap;

    public Cell(int value) {
        this.isFormula = false;
        this.value = value;
        this.children = new HashSet<>();
    }

    public Cell(HashMap<Cell, Integer> formulaMap) {
        this.isFormula = true;
        this.formulaMap = formulaMap;
        this.value = calculateValue();
        this.children = new HashSet<>();
    }

    public final int calculateValue() {
        if (!isFormula) {
            return value;
        }
        value = 0;
        for (Cell cell : formulaMap.keySet()) {
            value += formulaMap.get(cell) * cell.value;
        }
        return value;
    }
}

class Excel {
    // every cell need to have it own topological ordering
    // when we change a cell all the children need to updated as well
    Cell[][] matrix;

    public Excel(int height, char width) {
        this.matrix = new Cell[height][width - 'A' + 1];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width - 'A' + 1; j++) {
                matrix[i][j] = new Cell(0);
            }
        }

    }

    public void set(int row, char column, int val) {
        row -= 1;
        Cell cell = matrix[row][column - 'A'];
        // if cell is a value
        if (cell.isFormula) {
            // if a formula becomes a value then remove the dependency connections
            for (Cell parent : cell.formulaMap.keySet()) {
                parent.children.remove(cell);
            }
            cell.isFormula = false;
            cell.formulaMap.clear();
        }
        cell.value = val;
        dfsTopogolicalUpdate(matrix[row][column - 'A']);

    }

    public void dfsTopogolicalUpdate(Cell cell) {
        if (cell == null) {
            return;
        }
        cell.calculateValue();
        for (Cell child : cell.children) {
            dfsTopogolicalUpdate(child);
        }
    }

    public int get(int row, char column) {
        row -= 1;
        return matrix[row][column - 'A'].value;
    }

    public int sum(int row, char column, String[] numbers) {
        row -= 1;
        Cell c = matrix[row][column - 'A'];
        if (c.isFormula) {
            // if a formula becomes a value then remove the dependency connections
            for (Cell parent : c.formulaMap.keySet()) {
                parent.children.remove(c);
            }
        }
        HashMap<Cell, Integer> formulaMap = parseFormula(numbers);
        c.isFormula = true;
        c.formulaMap = formulaMap;
        c.calculateValue();
        for (Cell cell : c.formulaMap.keySet()) {
            cell.children.add(c); // added the created cell as dependency for the cell
        }
        dfsTopogolicalUpdate(c);
        return matrix[row][column - 'A'].value;
    }

    private int[] parseCell(String s) {
        int col = s.charAt(0) - 'A';
        int row = Integer.parseInt(s.substring(1)) - 1;

        return new int[] { row, col };
    }

    private HashMap<Cell, Integer> parseFormula(String[] numbers) {
        HashMap<Cell, Integer> formulaMap = new HashMap<>();
        for (String s : numbers) {
            if (!s.contains(":")) {
                int [] pos = parseCell(s);
                Cell cell = matrix[pos[0]][pos[1]];
                formulaMap.put(cell, formulaMap.getOrDefault(cell, 0) + 1);
            } else {
                String[] range = s.split(":");
                int [] start = parseCell(range[0]);
                int [] end = parseCell(range[1]);
                for (int i = start[0]; i <= end[0]; i++) {
                    for (int j = start[1]; j <= end[1]; j++) {
                        Cell cell = matrix[i][j];
                        formulaMap.put(cell, formulaMap.getOrDefault(cell, 0) + 1);
                    }
                }

            }
        }
        return formulaMap;
    }
}

/**
 * 
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */