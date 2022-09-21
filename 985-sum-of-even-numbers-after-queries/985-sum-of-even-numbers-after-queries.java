class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[nums.length];
        int EvenNum = 0;
        for(int j = 0; j < nums.length; j++){ 
            if(nums[j] % 2 == 0){
                EvenNum += nums[j];
            }
        }
        for(int i = 0; i < queries.length; i++){ 
            int index = queries[i][1];
            int value = queries[i][0];
            if(nums[index] % 2 == 0){
                if(value % 2 == 0){ 
                    EvenNum += value;
                }else{ 
                    EvenNum -= nums[index];
                }
            }else{
                if(value % 2 != 0){ 
                    EvenNum += value + nums[index];
                }
            }
            nums[index] += value;
            result[i] = EvenNum;
        }
        return result;
    }
}