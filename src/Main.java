void main() {
    System.out.println("Hello World!");

    ProductExceptSelf productExceptSelf = new ProductExceptSelf();
    int[] nums = {1, 2, 3, 4};
    int[] result = productExceptSelf.productExceptSelf(nums);
    System.out.println(Arrays.toString(result));

    LongestSubstring longestSubstring = new LongestSubstring();
    String s = "abcabcbb";
    int maxLength = longestSubstring.lengthOfLongestSubstring(s);
    System.out.println(maxLength);

    MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
    String s2 = "ADOBECODEBANC";
    String t = "ABC";
    String minWindow = minWindowSubstring.minWindow(s2, t);
    System.out.println(minWindow);

}
