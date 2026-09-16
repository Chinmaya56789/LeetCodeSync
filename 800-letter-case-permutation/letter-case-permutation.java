import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, s.toCharArray(), 0);
        return ans;
    }

    private void backtrack(List<String> ans, char[] s, int index) {
        if (index == s.length) {
            ans.add(new String(s));
            return;
        }

        if (Character.isDigit(s[index])) {
            backtrack(ans, s, index + 1);
        } else {
            // Lowercase branch
            s[index] = Character.toLowerCase(s[index]);
            backtrack(ans, s, index + 1);

            // Uppercase branch
            s[index] = Character.toUpperCase(s[index]);
            backtrack(ans, s, index + 1);
        }
    }
}