package String;

import java.util.ArrayList;
import java.util.List;

public class _String_pailie {

    List<String> stringList = new ArrayList<>();

    public List<String> permutation(String string) {
        char[] chars = string.toCharArray();
        permutationHelper(chars, 0);
        return stringList;
    }

    private void permutationHelper(char[] chars, int index){
        if (index >= chars.length-1) {
            stringList.add(String.valueOf(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            permutationHelper(chars, index + 1);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int sourceIndex, int targetIndex){
        char temp = chars[sourceIndex];
        chars[sourceIndex] = chars[targetIndex];
        chars[targetIndex] = temp;
    }

    public static void main(String[] args) {
        _String_pailie main = new _String_pailie();
        System.out.println(main.permutation("abcd"));
    }
}
