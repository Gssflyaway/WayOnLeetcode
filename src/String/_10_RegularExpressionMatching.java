package String;

public class _10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null || p == null)
            return false;

        if (s.length() == 0 && p.length() == 0)
            return true;

        return match(s, 0, p, 0);
    }

    private boolean match(String s, int sIndex, String p, int pIndex) {
        if (sIndex >= s.length() && pIndex >= p.length())
            return true;
        if (sIndex < s.length() && pIndex >= p.length())
            return false;

//        if (p.charAt(pIndex) != '.' && s.charAt(sIndex) != p.charAt(pIndex))//不能先判断是否相等，因为如果第一个元素就是不等的，而且第二位是*，很有可能模式中第一个字母不匹配
//            return false;
//        else{
//            if(pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*'){
//                return match(s, sIndex, p, pIndex + 2) || match(s, sIndex + 1, p, pIndex + 2) || match(s, sIndex + 1, p, pIndex);
//            }
//            if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) != '*'){
////                if (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex)) 这是隐藏条件，上面已经判断过了
//                return match(s, sIndex + 1, p, pIndex + 1);
//            }
//        }

        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            if ((sIndex < s.length() && p.charAt(pIndex) == '.') || (sIndex < s.length() && p.charAt(pIndex) == s.charAt(sIndex)))
                return match(s, sIndex, p, pIndex + 2) || match(s, sIndex + 1, p, pIndex + 2) || match(s, sIndex + 1, p, pIndex);
            else
                return match(s, sIndex, p, pIndex + 2);
        }else {
            if ((sIndex < s.length() && p.charAt(pIndex) == '.') || (sIndex < s.length() && p.charAt(pIndex) == s.charAt(sIndex)))
                return match(s, sIndex + 1, p, pIndex + 1);
            else
                return false;
        }
    }

    public static void main(String[] args) {
        _10_RegularExpressionMatching main = new _10_RegularExpressionMatching();
        System.out.println(main.isMatch("", ".*"));
    }
}
