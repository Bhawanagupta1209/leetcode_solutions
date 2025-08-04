class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length()<p.length()) return result;
        Map<Character,Integer> pMap = new HashMap<>();
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char c:p.toCharArray()){
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }
        int right=0,left=0;
        while(right<s.length()){
            char c = s.charAt(right);
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
            // Shrink the window if size exceeds p length
            if(right-left+1>p.length()){
                char leftC = s.charAt(left);
                freqMap.put(leftC,freqMap.get(leftC)-1);
                if(freqMap.get(leftC)==0){
                    freqMap.remove(leftC);
                }
                left++;
            }
            //Compare Maps
            if(right-left+1==p.length()&&freqMap.equals(pMap)){
                result.add(left);
            }
            right++;
        }
        return result;
    }
}
