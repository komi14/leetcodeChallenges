class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int start = 0, end = tokens.length - 1;
        int maxScore = 0;
        int currScore = 0;
        int p = power;
        
        while(start <= end){
            if(p < tokens[start] && currScore == 0)
                break;
            
            if(p >= tokens[start]){
                p -= tokens[start];
                currScore++;
                start++;
                
                if(currScore > maxScore){
                    maxScore = currScore;
                }
            }else if(p < tokens[start] && currScore > 0){
                currScore--;
                p += tokens[end];
                end--;
            }
        }
        
        return maxScore;
    }
}