class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-Heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num:nums){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    
    }
}
