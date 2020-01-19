## Smart Delimiter Predictor!
A Java Class that can autocomplete delimiters and tell you exactly which function is associated with a closing delimiter!

*Based on my curiosity of figuring out how the human brain finds patterns to match delimiters so easily.*

## Installation
The only file in this repo you need is the `SmartDelimiterPredictor.jar`. You can get this through 2 methods -
* You can download the whole repo as a zip and then extract the `.jar` file
* You can open `SmartDelimiterPredictor.jar` in [raw](https://raw.githubusercontent.com/TotallyNotChase/Smart-Delimiter-Predictor/master/SmartDelimiterPredictor.jar) mode and use your browser's `Save as..` option to save it as a `.jar` file
* You can run the following command to download it directly from terminal.

  `curl -o SmartDelimiterPredictor.jar https://raw.githubusercontent.com/TotallyNotChase/Smart-Delimiter-Predictor/master/SmartDelimiterPredictor.jar`

Now you can add this jar as an external archive to any of your projects and import the class using

`import com.github.chase.smartdelimiter.SmartDelimiterPredictor;`

## Usage
First instantiate the class using:

`SmartDelimiterPredictor sdp = new SmartDelimiterPredictor();`

Then, you may call the available methods.

There are 4 methods in the `SmartDelimiterPredictor` class.
* `closeDelimiters(String expression)` : Returns a string with all open delimiters in expression closed. If `expression` is `loge[sin(2+56^{58*cos(log0[` it will return `loge[sin(2+56^{58*cos(log0[])})]`

* `findFunctionForBrackettAt(int index, String[] expression)` : Returns the function associated with the closing brackett at given index. If `expression` is ``["loge", "[", "sin", "[", "2", "+", "56", "^", "{", "58", "*", "cos", "[", "log0", "[", "23", "]", "]", "}", "]", "]"]`` and if the `index` is 17 it will return cos

* `findFunctionForBraceAt(int index, String[] expression)` : Same as above but for braces.

* `findFunctionForParenthesisAt(int index, String[] expression)` : Same as above but for parenthesis.

## Example
Check out an example of how it's supposed to be used [here](https://raw.githubusercontent.com/TotallyNotChase/Smart-Delimiter-Predictor/master/SmartDelimiterPredictor.jar)

![image](https://user-images.githubusercontent.com/44284917/72676531-2eb18200-3ab8-11ea-9314-f881a7bf7704.png)

## How does it work?
Basically I got the idea for the algo from thinking *step by step* about how the human brain does it in the first place. The code has an explanation for all the algos.

Check out the [source code](https://raw.githubusercontent.com/TotallyNotChase/Smart-Delimiter-Predictor/master/SmartDelimiterPredictor.jar) as well as the [example](https://raw.githubusercontent.com/TotallyNotChase/Smart-Delimiter-Predictor/master/SmartDelimiterPredictor.jar) and follow along!

As always, using the algo yourself and tracking the variables will make it easier to understand.
