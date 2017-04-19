package String;

import java.util.Arrays;

/**
 * Created by gssflyaway on 2017/4/19.
 */
public class _556_NextGreaterElement3 {

    public int nextGreaterElement(int n) {
        char[] input, comparison;
//        char[] test;
        input = String.valueOf(n).toCharArray();
        comparison = input;
//        test = input.clone();
        Arrays.sort(comparison);
//        System.out.println(input);
//        System.out.println(comparison);
//        System.out.println(test);
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(comparison));
        String inputString = input.toString();
        String resultString = stringBuffer.reverse().toString();
        System.out.println(resultString);
        if (resultString.equals(inputString)){
            return -1;
        }else {
            return Integer.parseInt(resultString);
        }
    }

    public static void main(String[] args) {
        _556_NextGreaterElement3 test = new _556_NextGreaterElement3();
        test.nextGreaterElement(532);
    }
}
