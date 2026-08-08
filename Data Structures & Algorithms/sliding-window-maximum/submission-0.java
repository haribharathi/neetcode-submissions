class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> output = new ArrayList<>();
        int l = 0, currMax = -100000, currMaxIndex = 0;
        int[] windowArr = new int[k];
        Map<Integer,Integer> windowMap = new HashMap<>();
        for (int r = 0; r < nums.length; r++) {
            windowMap.put(r, nums[r]);
            if (nums[r] > currMax) {
                currMax = nums[r];
                currMaxIndex = r;
            }
            while (r - l + 1 > k) {
                Integer removedVal = windowMap.remove(l);
                if (l == currMaxIndex) {
                    int newMax = -100000, nexMaxIndex = 0;
                    for (Map.Entry<Integer, Integer> each : windowMap.entrySet())   {
                        if (newMax < each.getValue()) {
                            newMax = each.getValue();
                            nexMaxIndex = each.getKey();
                        }
                    }
                    currMax = newMax;
                    currMaxIndex = nexMaxIndex;
                }
                l++;
            }
             if (r - l + 1 == k) {
                output.add(currMax);
            }
        }
        return output.stream().mapToInt(i -> i).toArray();
    }
 
}
