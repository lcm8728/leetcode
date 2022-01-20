class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1;
        
        for(int pile : piles)
            if(pile > r) 
                r = pile;
        
        while(l < r) {
            int m = (r - l) / 2 + l;
            int hourSpent = 0;
            
            for(int pile : piles)
                hourSpent += Math.ceil((double)pile / m);
            
            if(hourSpent <= h) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return r;
    }
}