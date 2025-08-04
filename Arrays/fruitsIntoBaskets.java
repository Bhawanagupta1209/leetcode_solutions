class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0,right=0;
        int maxFruits = 0;
        Map<Integer,Integer> countMap = new HashMap<>();
        for(right=0;right<n;right++){
            countMap.put(fruits[right],countMap.getOrDefault(fruits[right],0)+1);
            if(countMap.size()>2){
                countMap.put(fruits[left],countMap.get(fruits[left])-1);
                if(countMap.get(fruits[left])==0){
                    countMap.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits,right-left+1);
        }
        return maxFruits;
        
    }
}
