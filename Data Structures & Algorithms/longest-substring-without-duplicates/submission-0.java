class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 1, len = s.length(),max = 0;
        while (l < len) {
            set.add(s.charAt(l));
            r = l == r ? l + 1 : r;
            while (r < len && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            max = Math.max(max, r - l);
            set.remove(s.charAt(l));
            l++;
        }
        return max;
    }
}
