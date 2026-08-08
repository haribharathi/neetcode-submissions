class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        Integer subLen = Integer.MAX_VALUE;
        String subString = "";
        if (sLen < tLen) {
            return "";
        }
        Map<Character, Integer> tMap = getMap(t);
        int need = tMap.keySet().size();
        int have = 0, l =0;
        //System.out.println("l" + tMap);
        Map<Character, Integer> sMap = new HashMap<>();
        for (int r  = 0; r < sLen; r++) {
            Character c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c,0) + 1);
            if (tMap.containsKey(c) && sMap.get(c).equals(tMap.get(c))) {
                have++;
            }
            //System.out.println("l" + sMap);
            while (need == have) {
                Character lc = s.charAt(l);
                //System.out.println("lc" + lc + " tMap " + tMap.get(lc) + " sMap" + sMap.get(lc));
                int sVal = sMap.get(lc);
                if (tMap.containsKey(lc) && sVal<=tMap.get(lc)) {
                    have--;
                }
                if (sMap.containsKey(lc)){
                    Integer val = sMap.get(lc);
                    val--;
                    if (val <= 0) {
                        sMap.remove(lc);
                    } else {
                        sMap.put(lc,val);
                    }
                }
                if (r - l < subLen) {
                    subString = s.substring(l,r + 1);
                    subLen = r - l;
                }
                l++;
            }
        }
        return subString;
    }

    public Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        return map;
    }
}
