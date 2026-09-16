class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        recrusive(new ArrayList<>(), nums, target, 0, 0);
        return output;
    }
    public void recrusive(List<Integer> list, int[] nums, int target, int sum, int index){
         //System.out.println("list  " + list );
         //System.out.println("sum " + sum  );
         if (sum > target) {
            return;
         }
        if (sum == target){
            //System.out.println(sum + " " + list);
            output.add(new ArrayList<>(list));
            return;
        }
        if (index >= nums.length) {
            //System.out.println("Return");
            return;
        }
        list.add(nums[index]);
        sum = sum + nums[index];
        recrusive(list, nums, target, sum, index);
        //recrusive(list, nums, target, sum, index + 1);
        int num = list.remove(list.size() - 1);
        //System.out.println("num " + num   );
        sum = sum - num;
        recrusive(list, nums, target, sum, index + 1);
    }

}
