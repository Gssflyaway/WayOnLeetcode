package String;

import java.util.Arrays;

/*
这题尝试着用dp去想过，但是要记录shi是否访问过，那就需要创建很多数组来记录，这就不适用了。
这题是滑动窗口的题，定义一个start和end，一个一个char往后看，那么就很容易知道有下面几种情况
 a b c a 遇到第二个a时，新的start是上次的a的序号后面那个char的序号
 a b c b a 遇到第二个a是，新的start是a的序号后面那个char的序号和当前start(这时的start是c的序号，因为在扫第二个b时，start已经变成了c)更大的那个，而这就是规律。
* */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        int start = 0, end = 0;
        int[] indexOfChar = new int[128];
        Arrays.fill(indexOfChar, -1);
        indexOfChar[s.charAt(0)] = 0;
        int max = 0;

        for (int i=1; i<s.length(); i++){
            if (indexOfChar[s.charAt(i)] != -1) {
                start = start > indexOfChar[s.charAt(i)] + 1 ? start : indexOfChar[s.charAt(i)] + 1;
            }
            indexOfChar[s.charAt(i)] = i;
            end = i;
            max = max > end-start+1 ? max : end-start+1;
        }
        return max;
    }

    public static void main(String[] args) {
        new _3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aw");
    }
}
