class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visits = new boolean[nums.length];
        recursive(nums, new ArrayList<>(),visits);
        return output;
    }

    public void recursive(int[] nums, List<Integer> each,  boolean[] visits) {
        if (each.size() == nums.length) {
            output.add(new ArrayList<>(each));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visits[i]) {
                visits[i] = true;
                each.add(nums[i]);
                recursive(nums, each,visits);
                visits[i] = false;
                each.remove(each.size() - 1);
            }
           // recursive(nums, each, i, visits);
        }
    }
}
