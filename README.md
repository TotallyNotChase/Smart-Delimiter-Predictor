## Smart Delimiter Predictor!
A Java Class that can autocomplete delimiters and tell you exactly which function is associated with a closing delimiter!

*Based on my curiosity of figuring out how the human brain finds patterns to match delimiters so easily.*

## Installation
The only file in this repo you need is the `SmartDelimiterPredictor.jar`. You can get this through 2 methods -
* You can download the whole repo as a zip and then extract the `.jar` file
* You can open `SmartDelimiterPredictor.jar` in [raw](https://raw.githubusercontent.com/TotallyNotChase/Smart-Delimiter-Predictor/master/SmartDelimiterPredictor.jar) mode, this will download the `.jar` file.
* You can run the following command to download it directly from terminal.

  `curl -o SmartDelimiterPredictor.jar https://raw.githubusercontent.com/TotallyNotChase/Smart-Delimiter-Predictor/master/SmartDelimiterPredictor.jar`

Now you can add this jar as an external archive to any of your projects and import the class using

`import com.github.chase.smartdelimiter.SmartDelimiterPredictor;`

## Features
* Well-documented code for you to follow along!
* Super modular! Can support *any delimiters*. The default supported delimiters are `(`\\`)`, `{`\\`}`, and `[`\\`]`
  However, you can add your own delimiter pairs anytime, in the **default constructor** of the class.
  Simply add your desired delimiters in `delimiterPair` and `delimiterCount` maps [here]()!


## Usage
First instantiate the class using:

`SmartDelimiterPredictor sdp = new SmartDelimiterPredictor();`

Then, you may call the available methods.

There are 2 methods in the `SmartDelimiterPredictor` class.
* `closeDelimiters(String expression)` : Returns a string with all open delimiters in expression closed. If `expression` is `loge[sin(2+56^{58*cos(log0[` it will return `loge[sin(2+56^{58*cos(log0[])})]`

* `findFunctionForDelimiterAt(int index, String[] expression, String delimiter)` : Returns the function associated with the given delimiter (open or closed) at given index.
  If `expression` is ``["loge", "[", "sin", "[", "2", "+", "56", "^", "{", "58", "*", "cos", "[", "log0", "[", "23", "]", "]", "}", "]", "]"]``
  and if the `index` is 17
  and if the delimiter is either `[` or `]`.
  it will return `cos`

Here is the **autocomplete** in action!

![Alt Text](https://thepracticaldev.s3.amazonaws.com/i/rgeqb9fmdlr69wspdpbo.gif)

*note that although the frontend shows only parentheses, the backend uses different delimiters for different functions, so it still uses the exact same algorithm*

And the **functionfinder**!

![Alt Text](https://thepracticaldev.s3.amazonaws.com/i/jz5j9ragmt70m62ajvnd.gif)

*notice that whenever I remove a closing delimiter using backspace, the program is able to tell which function region I just entered*

## Example
Check out an example of how it's supposed to be used [here](https://github.com/TotallyNotChase/Smart-Delimiter-Predictor/blob/master/Demo/src/SDPdemo.java)

![image](https://user-images.githubusercontent.com/44284917/72676531-2eb18200-3ab8-11ea-9314-f881a7bf7704.png)

## How does it work?
Basically I got the idea for the algo from thinking *step by step* about how the human brain does it in the first place. The code has an explanation for all the algos.

A detailed explanation can found [here](https://dev.to/totally_chase/how-is-the-human-brain-so-good-at-matching-delimiters-1o51)

Check out the [source code](https://github.com/TotallyNotChase/Smart-Delimiter-Predictor/blob/master/src/com/github/chase/smartdelimiter/SmartDelimiterPredictor.java) as well as the [example](https://github.com/TotallyNotChase/Smart-Delimiter-Predictor/blob/master/Demo/src/SDPdemo.java) and follow along!

As always, using the algo yourself and tracking the variables will make it easier to understand.
