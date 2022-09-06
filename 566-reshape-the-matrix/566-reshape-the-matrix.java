class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
    int cols = mat[0].length;
    
    if(rows*cols == r*c){
        int rcounter = 0;
        int ccounter = 0;
        int[][] singleMat= new int[r][c];
        
        for(int[] i : mat){
            for(int z :i){
                singleMat[rcounter][ccounter]=z;
                ccounter++;
                if(ccounter>c-1){
                    rcounter++;
                    ccounter=0;
                }
            }
        }
        return singleMat;
    }
    
    else return mat;
    
}
    }
