package com.github.chase.smartdelimiter;

import java.util.Arrays;

public class SmartDelimiterPredictor {

    public SmartDelimiterPredictor() {
        /**
         * Default Constructor
         */
    }

    public String closeDelimiters(String expression) {
        /**
         * Returns a string with all open delimiters in expression closed If expression
         * is "loge[sin(2+56^{58*cos(log0[" it will return
         * "loge[sin(2+56^{58*cos(log0[])})]"
         */
        StringBuilder resultstr = new StringBuilder(expression);
        String[] exparr = expression.split("");
        int closingParentheses = 0;
        int closingBraces = 0;
        int closingBrackets = 0;
        int openingParentheses = 0;
        int opening_brace = 0;
        int openingBrackets = 0;
        int i = exparr.length - 1;
        while (i >= 0) {
            /**
             * Iterating in reverse through each character in the expression Trying to find
             * delimiters
             */
            switch (exparr[i]) {
            /**
             * When an opening delimiter is found, a matching closing delimiter is appended
             * to the expression if the number of opening delimiters is more than closing
             * delimiters
             */
            /**
             * When a closing delimiter is found it's appearance is recorded
             */
            case "(":
                ++openingParentheses;
                if (openingParentheses > closingParentheses) {
                    resultstr.append(")");
                    closingParentheses++;
                }
                break;
            case "{":
                ++opening_brace;
                if (opening_brace > closingBraces) {
                    resultstr.append("}");
                    closingBraces++;
                }
                break;
            case "[":
                ++openingBrackets;
                if (openingBrackets > closingBrackets) {
                    resultstr.append("]");
                    closingBrackets++;
                }
                break;
            case ")":
                ++closingParentheses;
                break;
            case "}":
                ++closingBraces;
                break;
            case "]":
                ++closingBrackets;
                break;
            }
            i--;
        }
        return resultstr.toString();
    }

    public String findFunctionForBrackettAt(int index, String[] expression) {
        /**
         * Returns the function associated with the closing brackett at given index If
         * expression is ["loge", "[", "sin", "[", "2", "+", "56", "^", "{", "58", "*",
         * "cos", "[", "log0", "[", "23", "]", "]", "}", "]", "]"] and if the index is
         * 17 it will return cos
         */
        expression = Arrays.copyOfRange(expression, 0, index + 1);
        int i = expression.length - 2; // Skip the first closing delimiter
        int openBrackets = 0;
        int closeBrackets = 0;
        while (openBrackets <= closeBrackets) {
            /**
             * The expression's index is reduced until the number of opening delimiters is
             * greater than the number of closing delimiters
             */
            switch (expression[i]) {
            case "]":
                closeBrackets++;
                break;
            case "[":
                openBrackets++;
                break;
            }
            i--;
        }
        // The end result of i is the index of the function
        return expression[i].toString();
    }

    public String findFunctionForBraceAt(int index, String[] expression) {
        /**
         * Returns the function associated with the closing brace at given index If
         * expression is ["loge", "{", "sin", "{", "2", "+", "56", "^", "[", "58", "*",
         * "cos", "{", "log0", "{", "23", "}", "}", "]", "}", ")"] and if the index is
         * 17 it will return cos
         */
        expression = Arrays.copyOfRange(expression, 0, index + 1);
        int i = expression.length - 2; // Skip the first closing delimiter
        int openBraces = 0;
        int closeBraces = 0;
        while (openBraces <= closeBraces) {
            /**
             * The expression's index is reduced until the number of opening delimiters is
             * greater than the number of closing delimiters
             */
            switch (expression[i]) {
            case "}":
                closeBraces++;
                break;
            case "{":
                openBraces++;
                break;
            }
            i--;
        }
        // The end result of i is the index of the function
        return expression[i].toString();
    }

    public String findFunctionForParenthesisAt(int index, String[] expression) {
        /**
         * Returns the function associated with the closing parenthesis at given index
         * If expression is ["loge", "(", "sin", "(", "2", "+", "56", "^", "{", "58",
         * "*", "cos", "(", "log0", "(", "23", ")", ")", "}", ")", ")"] and if the index
         * is 17 it will return cos
         */
        expression = Arrays.copyOfRange(expression, 0, index + 1);
        int i = expression.length - 2; // Skip the first closing delimiter
        int openParentheses = 0;
        int closeParentheses = 0;
        while (openParentheses <= closeParentheses) {
            // An Algorithm to find out the position of the corresponding function
            switch (expression[i]) {
            case ")":
                closeParentheses++;
                break;
            case "(":
                openParentheses++;
                break;
            }
            i--;
        }
        // The end result of i is the index of the function
        return expression[i].toString();
    }
}
