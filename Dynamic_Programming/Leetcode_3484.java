package Dynamic_Programming;

public class Leetcode_3484 {
    class Spreadsheet {
    
    private int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows][26]; // Each row has 26 columns (A-Z)
    }
    
    private int[] parseCell(String cell) {
        int col = cell.charAt(0) - 'A'; // Extract column (A=0, B=1, ..., Z=25)
        int row = Integer.parseInt(cell.substring(1)) - 1; // Convert row (1-based to 0-based)
        return new int[]{row, col};
    }

    public void setCell(String cell, int value) {
        int[] coordinates = parseCell(cell);
        sheet[coordinates[0]][coordinates[1]] = value;
    }
    
    public void resetCell(String cell) {
        int[] coordinates = parseCell(cell);
        sheet[coordinates[0]][coordinates[1]] = 0;
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1); // Remove '='
        String[] parts = formula.split("\\+"); // Split at '+'

        return getOperandValue(parts[0]) + getOperandValue(parts[1]);
    }

    private int getOperandValue(String operand) {
        if (Character.isLetter(operand.charAt(0))) { // If it's a cell reference
            int[] coordinates = parseCell(operand);
            return sheet[coordinates[0]][coordinates[1]];
        }
        return Integer.parseInt(operand); // It's a number
    }
}

}
