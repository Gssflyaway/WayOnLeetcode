package DP;

public class _87_ScrambleString {
    public int[] charRecord = new int[26];
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        for (int i=0; i<charRecord.length; i++)
            charRecord[i] = 0;
        for (int i=0; i<s1.length(); i++)
            charRecord[s1.charAt(i) - 'a']++;
        for (int i=0; i<s2.length(); i++)
            charRecord[s2.charAt(i) - 'a']--;
        for (int i=0; i<charRecord.length; i++){
            if (charRecord[i] != 0)
                return false;
        }

        for (int i=1; i<s1.length(); i++){
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }
}
