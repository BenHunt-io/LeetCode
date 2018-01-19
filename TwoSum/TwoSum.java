class Solution {
    
    
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> numMap = new HashMap<>();
        int[] result = new int[2];
        bool flag = false;
        
        
        for(int i = 0; i < nums.length; i++){
            if(!numMap.containsKey(nums[i])){
                numMap.put(nums[i],i);
                flag = true;
            }
            
            if(numMap.containsKey(target - nums[i]) && numMap.get(target - nums[i]) != i){
                result[0] = numMap.get(target - nums[i]);
                result[1] = i;
                break;
            }
        }
        
        return result;
        
        }
        
    }