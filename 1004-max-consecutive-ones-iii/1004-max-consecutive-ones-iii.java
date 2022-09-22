class Solution {
    public int longestOnes(int[] A, int K) {
    int left = 0;
    int right = 0;
    int max = 0;
    int count = 0;

    while (right < A.length) {
      if (A[right] == 0) {
        count++;
      }
      right++;

      while (count > K) {
        if (A[left] == 0) {
          count--;
        }
        left++;
      }

      max = Math.max(max, right - left);
    }

    return max;
    }
}