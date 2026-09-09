class Solution {
    public List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        traverse(new ArrayList<>(), nums, 0);
        return output;
    }

    public void traverse(List<Integer> each, int[] nums, int index) {
        if (index == nums.length) {
            //System.out.println(each + " " + index);
            output.add(new ArrayList<>(each));
            return;
        }
        each.add(nums[index]);
        //System.out.println(each + " " + index);
        traverse(each, nums, index + 1);
        each.remove(each.size() - 1);
        //System.out.println(each + " " + index);
        traverse(each, nums, index + 1);
    }
}
