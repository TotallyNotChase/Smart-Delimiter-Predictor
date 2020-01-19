package com.github.chase.smartdelimiter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmartDelimiterPredictor {

    private Map<String, String> delimiterPair;
    private Map<String, Integer> delimiterCount;

    public SmartDelimiterPredictor() {
        /**
         * Default Constructor
         * Add more delimiters here if needed
         */
        this.delimiterPair = new HashMap<String, String>();
        this.delimiterCount = new HashMap<String, Integer>();
        delimiterPair.put("(", ")");
        delimiterPair.put("{", "}");
        delimiterPair.put("[", "]");
        delimiterCount.put("(", 0);
        delimiterCount.put("{", 0);
        delimiterCount.put("[", 0);
        delimiterCount.put(")", 0);
        delimiterCount.put("}", 0);
        delimiterCount.put("]", 0);
        cleanup();
    }
    
    private void cleanup() {
        this.delimiterCount.put("(", 0);
        this.delimiterCount.put("{", 0);
        this.delimiterCount.put("[", 0);
        this.delimiterCount.put(")", 0);
        this.delimiterCount.put("}", 0);
        this.delimiterCount.put("]", 0);
    }

    private String[] getCorrespondingDelimiter(String delimiter) {
        /**
         * Returns a string array with delimiter pairs
         * The 0th index contains the opening delimiter
         * The 1st index contains the closing delimiter
         */
        if (this.delimiterPair.get(delimiter) != null) {
            return new String[] {delimiter, this.delimiterPair.get(delimiter)};
        }
        for(String key: this.delimiterPair.keySet()) {
            if (this.delimiterPair.get(key).contentEquals(delimiter)) {
                return new String[] {key, delimiter};
            }
        }
        throw new IllegalArgumentException("Invalid Delimiter");
    }

    public String closeDelimiters(String expression) {
        /**
         * Returns a string with all open delimiters in expression closed If expression
         * is "loge[sin(2+56^{58*cos(log0[" it will return
         * "loge[sin(2+56^{58*cos(log0[])})]"
         */
        StringBuilder resultstr = new StringBuilder(expression);
        String[] exparr = expression.split("");
        String[] delimiterPair;
        int i = exparr.length - 1;
        int count;
        while (i >= 0) {
            /**
             * Iterating in reverse through each character in the expression Trying to find
             * delimiters
             */
            count = this.delimiterCount.getOrDefault(exparr[i], -1);
            if (count != -1) {
                // If it finds a delimiter, it increments it's appearance count
                this.delimiterCount.put(exparr[i], ++count);
                delimiterPair = getCorrespondingDelimiter(exparr[i]);
                if (this.delimiterCount.get(delimiterPair[0]) > this.delimiterCount.get(delimiterPair[1])) {
                    /**
                     * Then it checks if appearance count of the corresponding 
                     * opening delimiter is greater than the closing delimiter
                     * If the above statement is true, it'll append a closing delimiter
                     */
                    resultstr.append(delimiterPair[1]);
                }
            }
            i--;
        }
        cleanup();
        return resultstr.toString();
    }

    public String findFunctionForDelimiterAt(int index, String[] expression, String delimiter) {
        /**
         * Returns the function associated with the closing delimiter at given index. 
         * If the expression is ["loge", "[", "sin", "[", "2", "+", "56", "^", "{", "58", "*",
         * "cos", "[", "log0", "[", "23", "]", "]", "}", "]", "]"] 
         * and if the index is 17 
         * and if delimiter is "]" or "[" 
         * the function will return cos
         */
        expression = Arrays.copyOfRange(expression, 0, index + 1);
        int i = expression.length - 2; // Skip the first closing delimiter
        int openDelimiters = 0;
        int closeDelimiters = 0;
        String[] delimiterPair = getCorrespondingDelimiter(delimiter);
        while (openDelimiters <= closeDelimiters) {
            /**
             * The expression's index is reduced until the number of opening delimiters is
             * greater than the number of closing delimiters
             */
            if (expression[i].contentEquals(delimiterPair[0])) {
                openDelimiters++;
            } else if (expression[i].contentEquals(delimiterPair[1])) {
                closeDelimiters++;
            }
            i--;
        }
        // The end result of i is the index of the function
        return expression[i].toString();
    }
}