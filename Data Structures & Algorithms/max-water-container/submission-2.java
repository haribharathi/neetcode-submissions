class Solution {
    public int maxArea(int[] heights) {
        int output = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int minHeight = Math.min(heights[l],heights[r]);
            int width = r - l;
            output = Math.max(output, minHeight * width);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return output;
    }
}
