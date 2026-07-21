class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        int len = height.length;
        for (int i = 0; i < height.length; i++) {
            prefix[i] = i - 1 < 0 ? height[0] : Math.max(prefix[i - 1], height[i]);
            //suffix[height.length - 1 - i] = i + 1 >= len ? height[len - 1] : Math.max(suffix[len - i], height[len- i - 1]);
        }
        for (int i = len - 1; i >=0; i--) {
            suffix[i] = i + 1 == len ? height[len - 1] : Math.max(suffix[i + 1], height[i]);
        }
        int output = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(prefix[i], suffix[i]);
            int each = min - height[i];
            output += each;
        }
        return output;
    }
}
