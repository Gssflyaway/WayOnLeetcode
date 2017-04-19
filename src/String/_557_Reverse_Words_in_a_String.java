package String;

/**
 * Created by gssflyaway on 2017/4/18.
 */
public class _557_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        StringBuffer forward = new StringBuffer();
        StringBuffer store = new StringBuffer();
        for (int i=0; i<s.length(); i++){
            if (' ' != s.charAt(i)){
                forward.append(s.charAt(i));
            }else {
                store.append(forward.reverse()).append(" ");
                forward.delete(0, forward.length());
            }
        }
        store.append(forward.reverse());
        return store.toString();
    }

    public static void main(String[] args) {
        _557_Reverse_Words_in_a_String reverse = new _557_Reverse_Words_in_a_String();
        String s = "Let's take LeetCode contest";
        System.out.print(reverse.reverseWords(s));;
    }
}
