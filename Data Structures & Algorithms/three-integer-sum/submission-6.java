class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums); 
        int i = 0;
        do {
            if (!(i > 0 && nums[i] == nums[i - 1])) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    //System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    int add = nums[j] + nums[k];
                    int result = add + nums[i];
                    //System.out.println(result);
                    if (result == 0) {
                        output.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                            k--;
                        }
                        //System.out.println(j + " " + k);
                    }
                    if ( result < 0) {
                        j++;
                    } else if (result > 0) {
                        k--;
                    }
                }
            }
            i++;
        }while ( i < nums.length - 3);
        return output;
    }
}
