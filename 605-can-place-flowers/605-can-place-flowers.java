class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;        
        for(int i = 0; i < len; ++i) {
            if(flowerbed[Math.max(0, i - 1)] == 0 
               && flowerbed[Math.min(i + 1, len - 1)] == 0
               && flowerbed[i] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            if(n <= 0) return true;
        }
        return false;
    }
}