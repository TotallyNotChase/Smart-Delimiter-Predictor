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
		 * Returns a string with all open delimiters in expression closed
		 * If expression is "loge[sin(2+56^{58*cos(log0[" it will return
		 * "loge[sin(2+56^{58*cos(log0[])})]"
		 */
		StringBuilder resultstr = new StringBuilder(expression);
	    String[] exparr = expression.split("");
	    int closing_parenthesis = 0;
	    int closing_brace = 0;
	    int closing_brackett = 0;
	    int opening_parenthesis = 0;
	    int opening_brace = 0;
	    int opening_brackett = 0;
	    int i = exparr.length - 1;
	    while (i >= 0) {
	    	/**
	    	 * Iterating in reverse through each character in the expression
	    	 * Trying to find delimiters
	    	 */
	        switch (exparr[i]) {
	        	/**
	        	 * When an opening delimiter is found, a matching closing delimiter is appended
	        	 * to the expression if the number of opening delimiters is more than
	        	 * closing delimiters
	        	 */
		        /**
	        	 * When a closing delimiter is found it's appearance is recorded
	        	 */
	            case "(" :
	                ++opening_parenthesis;
	                if (opening_parenthesis > closing_parenthesis) {
	                    resultstr.append(")");
	                    closing_parenthesis++;
	                }
	                break;
	            case "{" :
	                ++opening_brace;
	                if (opening_brace > closing_brace) {
	                    resultstr.append("}");
	                    closing_brace++;
	                }
	                break;
	            case "[" :
	                ++opening_brackett;
	                if (opening_brackett > closing_brackett) {
	                    resultstr.append("]");
	                    closing_brackett++;
	                }
	                break;
	            case ")" : ++closing_parenthesis;
	                break;
	            case "}" : ++closing_brace;
	                break;
	            case "]" : ++closing_brackett;
	                break;
	        }
	        i--;
	    }
	    return resultstr.toString();
	}
	
	public String findFunctionForBrackettAt(int index, String[] expression) {
		/**
		 * Returns the function associated with the closing brackett at given index
		 * If expression is ["loge", "[", "sin", "[", "2", "+", "56", "^", "{", "58", "*", "cos", "[", "log0", "[", "23", "]", "]", "}", "]", "]"] 
		 * and if the index is 17 it will return cos
		 */
		expression = Arrays.copyOfRange(expression, 0, index + 1);
        int i = expression.length - 2; 		//Skip the first closing delimiter
        int open_Brackett = 0;
        int close_Brackett = 0;
        while (open_Brackett <= close_Brackett) {
            /** 
             * The expression's index is reduced until the 
             * number of opening delimiters is greater than the number of
             * closing delimiters
             */
            switch (expression[i]) {
                case "]": close_Brackett++;
                    break;
                case "[": open_Brackett++;
                    break;
            }
            i--;
        }
        // The end result of i is the index of the function
        return expression[i].toString();
	}
	
	public String findFunctionForBraceAt(int index, String[] expression) {
		/**
		 * Returns the function associated with the closing brace at given index
		 * If expression is ["loge", "{", "sin", "{", "2", "+", "56", "^", "[", "58", "*", "cos", "{", "log0", "{", "23", "}", "}", "]", "}", ")"] 
		 * and if the index is 17 it will return cos
		 */
		expression = Arrays.copyOfRange(expression, 0, index + 1);
        int i = expression.length - 2; 		//Skip the first closing delimiter
        int open_Brace = 0;
        int close_Brace = 0;
        while (open_Brace <= close_Brace) {
        	/** 
             * The expression's index is reduced until the 
             * number of opening delimiters is greater than the number of
             * closing delimiters
             */
            switch (expression[i]) {
                case "}": close_Brace++;
                    break;
                case "{": open_Brace++;
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
		 * If expression is ["loge", "(", "sin", "(", "2", "+", "56", "^", "{", "58", "*", "cos", "(", "log0", "(", "23", ")", ")", "}", ")", ")"] 
		 * and if the index is 17 it will return cos
		 */
		expression = Arrays.copyOfRange(expression, 0, index + 1);
        int i = expression.length - 2; 		//Skip the first closing delimiter
        int open_Parenthesis = 0;
        int close_Parenthesis = 0;
        while (open_Parenthesis <= close_Parenthesis) {
            // An Algorithm to find out the position of the corresponding function
            switch (expression[i]) {
                case ")": close_Parenthesis++;
                    break;
                case "(": open_Parenthesis++;
                    break;
            }
            i--;
        }
        // The end result of i is the index of the function
        return expression[i].toString();
	}
}
