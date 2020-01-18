package com.github.chase.smartdelimiter;

public class TestClass {
	public static void main(String[] args) {
		SmartDelimiterPredictor smd = new SmartDelimiterPredictor();
		System.out.println(smd.closeDelimiters("loge[sin(2+56^{58*cos(log0["));
		System.out.println(smd.findFunctionForParenthesisAt(19, new String[] {"loge", "(", "sin", "(", "2", "+", "56", "^", "{", "58", "*", "cos", "(", "log0", "(", "23", ")", ")", "}", ")", ")"}));
		System.out.println(smd.findFunctionForBraceAt(17, new String[] {"loge", "{", "sin", "{", "2", "+", "56", "^", "(", "58", "*", "cos", "{", "log0", "{", "23", "}", "}", "]", "}", "}"}));
		System.out.println(smd.findFunctionForBrackettAt(20, new String[] {"loge", "[", "sin", "[", "2", "+", "56", "^", "{", "58", "*", "cos", "[", "log0", "[", "23", "]", "]", "}", "]", "]"}));
	}
}
