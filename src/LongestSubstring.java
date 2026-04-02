import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> substringSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            if (!substringSet.contains(currentChar)) {
                substringSet.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                substringSet.remove(s.charAt(left));
                left++;
            }

        }

        return maxLength;

    }

}
