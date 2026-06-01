class Solution {
    private int[] temp;
    private int c = 0;
    private void mergeSort(int s, int e, int[] a) {
        if(s>=e)return;
        int m = (s+e)/2;
        mergeSort(s, m, a);
        mergeSort(m+1, e, a);
        merge(s, m, e, a);
    }
    private void merge(int s, int m, int e, int [] a) {
        int i = s, j = m+1, k = s;
        while(i<=m && j<=e) {
            if(a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                c += (m-i+1);
                temp[k++] = a[j++];
            }
        }
        while(i<=m) {
            c += (m-i+1);
            temp[k++] = a[i++];
        }
        while(j<=e) {
            temp[k++] = a[j++];
        }
        for(i=s;i<=e;i++) {
            a[i] = temp[i];
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        mergeSort(0, n-1, nums);
        System.out.println(c);
        return nums;
    }
}