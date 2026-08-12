class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1, end = piles[piles.length - 1], output = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (end + start)/2;
            int calhr = calc(h, piles, mid);
            if (calhr == -1) {
                start = mid + 1;
            } else {
                end = mid - 1;
                output = output > mid ? mid : output;
            }
        }
        return output;
    }

    public int calc(int h, int[] piles, int index) {
        int hr = 0;
        for (int i = 0; i < piles.length; i++) {
            int quot = piles[i]/index;
            int rem = piles[i]%index;
            hr += quot;
            hr = rem > 0 ? hr + 1 : hr;
            if (hr > h) {
                return - 1;
            }
        }
        return hr;
    }
}
