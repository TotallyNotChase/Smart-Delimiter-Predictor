## Smart Delimiter Predictor!
A Java Class that can autocomplete delimiters and tell you exactly which function is associated with a closing delimiter!

*Based on my curiosity of figuring out how the human brain finds patterns to match delimiters so easily.*

## Installation
I'll put a maven file in the repo soon for easy imports. Right now just downloading both `.java` files and running `TesterClass.java` should work for testing purposes.

## Usage
There are 4 methods in the `SmartDelimiterPredictor` class.
* `closeDelimiters(String expression)` : Returns a string with all open delimiters in expression closed. If `expression` is `loge[sin(2+56^{58*cos(log0[` it will return `loge[sin(2+56^{58*cos(log0[])})]`

* `findFunctionForBrackettAt(int index, String[] expression)` : Returns the function associated with the closing brackett at given index. If `expression` is ``["loge", "[", "sin", "[", "2", "+", "56", "^", "{", "58", "*", "cos", "[", "log0", "[", "23", "]", "]", "}", "]", "]"]`` and if the `index` is 17 it will return cos

* `findFunctionForBraceAt(int index, String[] expression)` : Same as above but for braces.

* `findFunctionForParenthesisAt(int index, String[] expression)` : Same as above but for parenthesis.

## How does it work?
Basically I got the idea for the algo from thinking *step by step* about how the human brain does it in the first place. The code has an explanation for all the algos.

As always, using the algo yourself and tracking the variables will make it easier to understand.
