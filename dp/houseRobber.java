class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int take = nums[i] + prev2;
            int notTake = 0+prev;
            int curri = Math.max(take,notTake);
            prev2 = prev;
            prev = curri;
        }
        return prev;
        
    }
}
