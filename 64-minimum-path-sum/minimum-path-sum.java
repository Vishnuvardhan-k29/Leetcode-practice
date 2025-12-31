class Solution {
    public static int minPathSum(int[][] mat) {
        int rSize = mat.length;
        int cSize = mat[0].length;
        for(int row=1;row<rSize;row++)
            mat[row][0] += mat[row-1][0];
        for(int col=1;col<cSize;col++)
            mat[0][col] += mat[0][col-1];
        for(int row=1;row<rSize;row++){
            for(int col=1;col<cSize;col++)
                mat[row][col] += Math.min(
                    mat[row-1][col],
                    mat[row][col-1]
                );
        }
        return mat[rSize-1][cSize-1];
    }
    public static void main(String[] args) {
        System.out.println(
            minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
            })
        );
        System.out.println(
            minPathSum(new int[][]{
                {1,2,3},
                {4,5,6}
            })
        );
    }
}
    