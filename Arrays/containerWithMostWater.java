class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int water = 0,maxWater = 0;
        int left = 0,right=n-1;
        while(left<right){
            int min = Math.min(height[left],height[right]);
            water = min*(right-left);
            maxWater = Math.max(water,maxWater);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
        
    }
}
