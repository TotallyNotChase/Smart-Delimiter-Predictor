import com.github.chase.smartdelimiter.SmartDelimiterPredictor;

public class SDPdemo {

    public static void main(String[] args) {
        SmartDelimiterPredictor sdp = new SmartDelimiterPredictor();
        sdp.addDelimiterPair("<", ">");
        System.out.println(sdp.closeDelimiters("loge[sin(2+56^{58*cos(log0<"));
        System.out.println(sdp.findFunctionForDelimiterAt(19, new String[] { "loge", "(", "sin", "(", "2", "+", "56",
                "^", "{", "58", "*", "cos", "(", "log0", "(", "23", ")", ")", "}", ")", ")" }, ")"));
        System.out.println(sdp.findFunctionForDelimiterAt(17, new String[] { "loge", "{", "sin", "{", "2", "+", "56", "^",
                "(", "58", "*", "cos", "{", "log0", "{", "23", "}", "}", "]", "}", "}" }, "{"));
        System.out.println(sdp.findFunctionForDelimiterAt(20, new String[] { "loge", "[", "sin", "[", "2", "+", "56",
                "^", "{", "58", "*", "cos", "[", "log0", "[", "23", "]", "]", "}", "]", "]" }, "["));
        System.out.println(sdp.findFunctionForDelimiterAt(18, new String[] { "loge", "<", "sin", "[", "2", "+", "56",
                "^", "<", "58", "*", "cos", "[", "log0", "[", "23", "]", "]", ">", "]", ">" }, ">"));
    }
}
