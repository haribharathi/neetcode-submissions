class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int mid = (start + end )/2;
        int output = Integer.MAX_VALUE;
        // if (nums[start] > nums[end] && nums[mid] > nums[end]) {
        //     start = mid;
        //     end = nums.length - 1;
        // } else if (nums[start] < nums[end] && nums[mid] < nums[end]) {
        //     end = mid;
        //     start = 0;
        // } else {
        //     return nums[mid];
        // }
        System.out.println("start" + start + " end" + end);
        while (start <= end ) {
             mid = (start + end)/2;
             if (nums[start] > nums[end] && nums[mid] > nums[end]) {
                start = mid + 1;
             } else {
                end = mid - 1;
             }
             output = output < nums[mid] ? output : nums[mid];
        }
        return output;
    }
}
