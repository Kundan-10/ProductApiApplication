package org.example;

import java.util.HashMap;
import java.util.Map;

public class CSVParser {
    private Map<String, String> csvData = new HashMap<>();

    public void parseCSV(String input) {
        String[] rows = input.split(",");
        for (String row : rows) {
            String[] cell = row.split(":");
            csvData.put(cell[0].trim(), cell[1].trim());
        }
    }

    public String evaluateFormula(String cell) {
        // Simplified formula evaluation (could use an expression evaluator or custom logic)
        if (cell.startsWith("=")) {
            String formula = cell.substring(1).trim();
            String[] parts = formula.split("\\+");
            int result = Integer.parseInt(parts[0].trim()) + Integer.parseInt(parts[1].trim());
            return String.valueOf(result);
        }
        return cell;
    }

    public String getCellValue(String cell) {
        String value = csvData.get(cell);
        if (value.startsWith("=")) {
            value = evaluateFormula(value);
            csvData.put(cell, value); // Store the evaluated value
        }
        return value;
    }

    public static void main(String[] args) {
        CSVParser parser = new CSVParser();
        String input = "A1: 5, A2: 7, A3: 9, B1: 3, B2: 8, B3: =4+5, C1: =5+A1, C2: =A2+B2, C3: =C2+B3";
        parser.parseCSV(input);
        System.out.println("A1: " + parser.getCellValue("A1"));
        System.out.println("B3: " + parser.getCellValue("B3"));
        System.out.println("C1: " + parser.getCellValue("C1"));
    }

}
