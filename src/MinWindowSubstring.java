import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        Map<Character, Integer> targetMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int required = targetMap.size();
        int formed = 0;
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c)) ) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);

                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowMap.put(c, windowMap.get(c) - 1);
                if (targetMap.containsKey(c) && windowMap.get(c) < targetMap.get(c)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return ans[0] != -1 ? s.substring(ans[1], ans[2] + 1) : "";
    }
}
