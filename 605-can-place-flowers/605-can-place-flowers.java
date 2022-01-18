class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;        
        for(int i = 0; i < len; ++i) {
            if(flowerbed[i] == 0 && flowerbed[(i == len - 1 ? len - 1 : i + 1)] == 0 && flowerbed[(i == 0 ? 0 : i - 1)] == 0 ) {
                flowerbed[i] = 1;
                n--;
            }
            if(n <= 0) return true;
        }
        return false;
    }
}