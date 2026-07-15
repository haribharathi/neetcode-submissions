class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] output = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length -1] = 1;
        for (int i = 1, j = nums.length - 2; i <= nums.length && j >= 0; i++, j--) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[j] = suffix[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix[i]*suffix[i];
        }
        return output;
    }
}  
