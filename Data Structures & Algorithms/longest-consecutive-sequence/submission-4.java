class Solution {
    public int longestConsecutive(int[] nums) {
        int output = 0, currLen = 1;
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (prev != curr) {
                if (prev == curr -1) {
                    //System.out.println(currLen + " " + prev + " " + curr);
                    currLen++;
                } else {
                    output = output < currLen ? currLen : output;
                    currLen = 1;
                }
                prev = curr;
            }
        }
        return output < currLen ? currLen : output;
    }
}
