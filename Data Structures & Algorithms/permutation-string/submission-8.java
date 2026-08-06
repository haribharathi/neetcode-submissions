class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int winLen = s1.length(), len = s2.length(), l = 0;
        //int actual = getCost(s1, 0, winLen - 1);
        HashMap<Character,Integer> actual = getCostMap(s1, 0, winLen - 1);
       // System.out.println(actual);
        HashMap<Character,Integer> cost = new HashMap<>();
        for (int r = 0;r < len;r++){
            cost.put(s2.charAt(r), cost.getOrDefault(s2.charAt(r),0) + 1);
            if (r - l + 1 == winLen) {
                if (!cost.equals(actual)) {
                    int value = cost.get(s2.charAt(l));
                    value--;
                    if (value == 0) {
                        cost.remove(s2.charAt(l));
                    } else {
                        cost.put(s2.charAt(l),value);
                    }
                    l++;
                } else {
                    //System.out.println("l" +s2.charAt(l) + "r" + s2.charAt(r));
                    //System.out.println(cost);
                    
                    return true;
                }
            }
        }
        return false;
    }
    public int getCost(String s, int l, int r) {
        int cost = 0;
        System.out.println("l" +l + "r" + r);
        for (int i = l; i <= r; i++) {
            cost = cost + s.charAt(i) - 'a';
           System.out.println("getCost" + s.charAt(i) + " " + cost);
        }
        return cost;
    }
    public HashMap<Character,Integer> getCostMap(String s, int l, int r) {
        //System.out.println("l" +l + "r" + r);
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = l; i <= r; i++) {
           map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
           //System.out.println("getCost" + s.charAt(i) + " " + cost);
        }
        return map;
    }
}
