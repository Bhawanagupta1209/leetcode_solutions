class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        // Calculate Prefix Products
        answer[0]=1;
        for(int i=1;i<n;i++){
            answer[i]=answer[i-1]*nums[i-1];
        }
        // Calculate suffix products and multiply it to answer
        int suffix =1;
        for(int i=n-1;i>=0;i--){
            answer[i]*=suffix;
            suffix*=nums[i];
        }
        return answer;

        
    }
}
