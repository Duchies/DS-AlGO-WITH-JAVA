class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int n = nums.length;
        long maxValue = 0,currValue = 0;
        while (j < n){
            currValue+=nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
           
            if  (j-i+1 == k){
                
                if (map.size() == k){
                    maxValue = Math.max(maxValue,currValue);
                }

                int cnt  = map.get(nums[i]);
                if (cnt == 1){
                    map.remove(nums[i]);
                }else{
                    map.put(nums[i],map.get(nums[i])-1);
                }

                currValue-=nums[i];
                j++;
                i++;
            }else{
                j++;
            }
        }

        return maxValue;
    }
}
