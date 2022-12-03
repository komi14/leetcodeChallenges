class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int freq[] = new int[128];
        for(char c: s.toCharArray()){
            freq[c]++;    
        }

        int count=0;
        StringBuilder val = new StringBuilder();

        while(count!=n){
            int max = 0;

            for(int i=0;i<128;i++){
                if(freq[i]>freq[max]){
                    max =i;
                }
            }
            int times = freq[max];
            freq[max]=0;
            char c = (char)max;
            
            while(times>0){
                val.append(c);
                times--;
                count++;
            }
        }
        return val.toString();
    }
}