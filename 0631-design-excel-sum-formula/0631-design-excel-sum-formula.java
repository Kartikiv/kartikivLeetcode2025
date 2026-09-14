import java.util.*;

class Cell {
    int value;
    boolean isFormula;

    // Cells whose formulas depend on this cell
    Set<Cell> children = new HashSet<>();

    // Parent cell -> number of times it appears in formula
    Map<Cell, Integer> formulaMap = new HashMap<>();

    public Cell(int value) {
        this.value = value;
        this.isFormula = false;
    }

    public int calculateValue() {
        if (!isFormula) {
            return value;
        }

        int newValue = 0;

        for (Map.Entry<Cell, Integer> entry : formulaMap.entrySet()) {
            Cell parent = entry.getKey();
            int weight = entry.getValue();

            newValue += parent.value * weight;
        }

        value = newValue;
        return value;
    }
}

class Excel {

    Cell[][] matrix;

    public Excel(int height, char width) {

        int columns = width - 'A' + 1;

        matrix = new Cell[height][columns];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = new Cell(0);
            }
        }
    }

    public void set(int row, char column, int val) {

        Cell cell = matrix[row - 1][column - 'A'];

        // If this cell previously had a formula,
        // disconnect it from its old parents.
        removeOldFormula(cell);

        // IMPORTANT: mutate existing object.
        // Do NOT create a new Cell.
        cell.isFormula = false;
        cell.formulaMap.clear();
        cell.value = val;

        updateDependents(cell);
    }

    public int get(int row, char column) {
        return matrix[row - 1][column - 'A'].value;
    }

    public int sum(int row, char column, String[] numbers) {

        Cell cell = matrix[row - 1][column - 'A'];

        // Disconnect previous formula if one existed
        removeOldFormula(cell);

        Map<Cell, Integer> formula = parseFormula(numbers);

        cell.isFormula = true;
        cell.formulaMap = formula;

        // Parent -> child dependency edges
        for (Cell parent : formula.keySet()) {
            parent.children.add(cell);
        }

        cell.calculateValue();

        // Since this cell changed, update everything downstream.
        updateDependents(cell);

        return cell.value;
    }

    private void removeOldFormula(Cell cell) {

        if (!cell.isFormula) {
            return;
        }

        for (Cell parent : cell.formulaMap.keySet()) {
            parent.children.remove(cell);
        }

        cell.formulaMap.clear();
    }

    private void updateDependents(Cell source) {

        List<Cell> order = new ArrayList<>();
        Set<Cell> visited = new HashSet<>();

        dfs(source, visited, order);

        // DFS postorder gives:
        //
        // descendant -> ... -> source
        //
        // Reverse to obtain:
        //
        // source -> ... -> descendant

        Collections.reverse(order);

        for (Cell cell : order) {
            if (cell != source && cell.isFormula) {
                cell.calculateValue();
            }
        }
    }

    private void dfs(
            Cell cell,
            Set<Cell> visited,
            List<Cell> order) {

        if (!visited.add(cell)) {
            return;
        }

        for (Cell child : cell.children) {
            dfs(child, visited, order);
        }

        order.add(cell);
    }

    private Map<Cell, Integer> parseFormula(String[] numbers) {

        Map<Cell, Integer> formula = new HashMap<>();

        for (String s : numbers) {

            if (!s.contains(":")) {

                Cell cell = getCell(s);

                formula.put(
                        cell,
                        formula.getOrDefault(cell, 0) + 1
                );

            } else {

                String[] range = s.split(":");

                int[] start = parsePosition(range[0]);
                int[] end = parsePosition(range[1]);

                for (int row = start[0]; row <= end[0]; row++) {

                    for (int col = start[1]; col <= end[1]; col++) {

                        Cell cell = matrix[row][col];

                        formula.put(
                                cell,
                                formula.getOrDefault(cell, 0) + 1
                        );
                    }
                }
            }
        }

        return formula;
    }

    private Cell getCell(String position) {

        int[] coordinates = parsePosition(position);

        return matrix[coordinates[0]][coordinates[1]];
    }

    private int[] parsePosition(String position) {

        int col = position.charAt(0) - 'A';

        int row =
                Integer.parseInt(position.substring(1)) - 1;

        return new int[]{row, col};
    }
}