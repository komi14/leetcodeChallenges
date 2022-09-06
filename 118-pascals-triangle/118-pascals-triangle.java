class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for(int i=1;i<numRows;i++) {
            List<Integer> prevList = result.get(i-1);
            List<Integer> currList = new ArrayList<>();
            for(int j=0;j<=i;j++) {
                if(j==i || j==0) currList.add(1);
                else currList.add(prevList.get(j) + prevList.get(j-1));
            }
            result.add(currList);
        }
        return result;
    }
}