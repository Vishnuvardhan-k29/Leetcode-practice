import java.util.Arrays;

class Solution {
    public static void ordering(int[] packs, int start, int mid, int end){
        int lSize = mid - start + 1;
        int rSize = end - mid;

        int[] left = new int[lSize];
        int[] right = new int[rSize];

        for(int i = 0; i < lSize; i++){
            left[i] = packs[start + i];
        }
        for(int i = 0; i < rSize; i++){
            right[i] = packs[mid + 1 + i];
        }

        int l = 0, r = 0, k = start;

        while(l < lSize && r < rSize){
            if(left[l] <= right[r]){
                packs[k++] = left[l++];
            } else {
                packs[k++] = right[r++];
            }
        }

        while(l < lSize){
            packs[k++] = left[l++];
        }
        while(r < rSize){
            packs[k++] = right[r++];
        }
    }
    public static void sortByDivide(int[] packages, int start, int end){
        if(start < end){
            int mid = start + (end - start) / 2;
            sortByDivide(packages, start, mid);
            sortByDivide(packages, mid + 1, end);
            ordering(packages, start, mid, end);
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++){
            nums1[m + i] = nums2[i];
        }
        sortByDivide(nums1, 0, m + n - 1);
    }
}
