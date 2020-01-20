package com.github.chase.smartdelimiter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmartDelimiterPredictor {

    private Map<String, String> delimiterPair;
    

    public SmartDelimiterPredictor() {
        /**
         * Default Constructor
         */
        this.delimiterPair = new HashMap<String, String>();
        delimiterPair.put("(", ")");
        delimiterPair.put("{", "}");
        delimiterPair.put("[", "]");
    }
    
    public void addDelimiterPair(String openingDelimiter, String closingDelimiter) {
        /**
         * Add more delimiter pairs here
         */
        delimiterPair.put(openingDelimiter, closingDelimiter);
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
        Map<String, Integer> delimiterCount = new HashMap<String, Integer>();
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
            try {
                delimiterPair = getCorrespondingDelimiter(exparr[i]);
                if (delimiterCount.get(exparr[i]) == null) {
                    delimiterCount.put(exparr[i], 1);
                    count = 1;
                } else {
                    count = delimiterCount.get(exparr[i]);
                    delimiterCount.put(exparr[i], ++count);
                }
                if (exparr[i].equals(delimiterPair[0]) && (count > delimiterCount.getOrDefault(delimiterPair[1], 0))) {
                    resultstr.append(delimiterPair[1]);
                }
            } catch (IllegalArgumentException e) {
                // exparr[i] is not in the recorded delimiter array
                // Safe to ignore
            }
            i--;
        }
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