package utils;

import java.util.*;

/**
 * 🔢 Parses calculation rules like "C = A + B" or "Sheet2.D = Sheet1.A + Sheet1.B"
 * Supports +, -, *, / and percentage constants like "8.33%"
 */
public class ExcelExpressionParser {

    /** Represents a single parsed rule (LHS = RHS). */
    public static class ParsedRule {
        public String leftSheet;    // null means same sheet
        public String leftColumn;   // e.g. "C"
        public List<Token> rhsTokens; // expression tokens
    }

    /** Token types for RHS */
    public static class Token {
        public enum Type { COLUMN, NUMBER, OPERATOR }
        public Type type;
        public String sheetName;  // for COLUMN
        public String column;     // e.g. "A", "D"
        public Double number;     // for NUMBER
        public String operator;   // + - * / for OPERATOR
    }

    /**
     * Parse a calculation rule string.
     * Example: "Sheet1.C = Sheet1.A + Sheet2.B * 8.33%"
     */
    public static ParsedRule parse(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression is empty");
        }

        String[] sides = expression.split("=");
        if (sides.length != 2) {
            throw new IllegalArgumentException("Invalid expression, must contain '=': " + expression);
        }

        ParsedRule rule = new ParsedRule();

        // LHS
        String lhs = sides[0].trim();
        if (lhs.contains(".")) {
            String[] parts = lhs.split("\\.");
            rule.leftSheet = parts[0].trim();
            rule.leftColumn = parts[1].trim();
        } else {
            rule.leftSheet = null;
            rule.leftColumn = lhs;
        }

        // RHS tokenize
        String rhs = sides[1].trim();
        rule.rhsTokens = tokenize(rhs);

        return rule;
    }

    /** Tokenizer for RHS (very simple split by space) */
    private static List<Token> tokenize(String rhs) {
        List<Token> tokens = new ArrayList<>();
        String[] parts = rhs.split("\\s+");
        for (String part : parts) {
            if (part.equals("+") || part.equals("-") || part.equals("*") || part.equals("/")) {
                Token t = new Token();
                t.type = Token.Type.OPERATOR;
                t.operator = part;
                tokens.add(t);
            } else if (part.matches("[A-Z]+")) {
                Token t = new Token();
                t.type = Token.Type.COLUMN;
                t.column = part;
                tokens.add(t);
            } else if (part.matches("[A-Za-z0-9_]+\\.[A-Z]+")) {
                // format: SheetName.Column
                String[] arr = part.split("\\.");
                Token t = new Token();
                t.type = Token.Type.COLUMN;
                t.sheetName = arr[0];
                t.column = arr[1];
                tokens.add(t);
            } else if (part.endsWith("%")) {
                // percentage literal
                String num = part.substring(0, part.length() - 1);
                double val = Double.parseDouble(num) / 100.0;
                Token t = new Token();
                t.type = Token.Type.NUMBER;
                t.number = val;
                tokens.add(t);
            } else {
                // plain number
                double val = Double.parseDouble(part);
                Token t = new Token();
                t.type = Token.Type.NUMBER;
                t.number = val;
                tokens.add(t);
            }
        }
        return tokens;
    }
}
