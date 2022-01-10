// https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

public class SortArray012 {

    static void printArr(int a[], int n){
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // 1. Simple Counting method - O(n)
    //      Count the 0s, 1s and 2s and put the 0s, 1s and 2s in array based on count.

    public static void simpleCounting(int a[], int n){
        int count0 = 0, count1 = 0, count2 = 0;

        for(int i=0; i < n; i++){
            if(a[i] == 0) count0++;
            if(a[i] == 1) count1++;
            if(a[i] == 2) count2++;
        }

        for(int i=0; i < count0; i++){
            a[i] = 0;
        }

        for(int i=count0; i< (count0 + count1); i++){
            a[i] = 1;
        }

        for(int i= (count0 + count1); i < n; i++){
            a[i] = 2;
        }

        printArr(a, n);
    }

    // 2. Dutch National Flag Method - O(n)
    //      i) Initialize l = 0, h = n-1, mid = 0. 
    //      ii) 4 ranges - 0 to low (Range containing 0)
    //                   - low to mid (Range containing 1)
    //                   - mid to high (Range containing unknown)
    //                   - high to n (Range containing 2)
    //      iii) In loop, from start to end, while mid <= high
    //              If 0, Swap element with index low, low++, mid++
    //              If 1, mid++.
    //              If 2, Swap element with index high, high--.

    static void dutchNationalFlagMethod(int a[], int n){
        int l = 0;
        int h = n-1;
        int mid = 0, temp = 0;

        while(mid <= h){
            switch(a[mid]){
                case 0: {
                    temp = a[l];
                    a[l] = a[mid];
                    a[mid] = temp;
                    l++;
                    mid++;
                    break;
                }

                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = a[mid];
                    a[mid] = a[h];
                    a[h] = temp;
                    h--;
                    break;
                } 
            }
            
        }
    
        printArr(a, n);
    }
    
    public static void main(String[] args) {
        int arr[] = {0, 2, 2, 0, 1, 1, 1, 1};
        int n = arr.length;
        System.out.print("Array - ");
        printArr(arr, n);
        System.out.print("1. Simple Counting Method     - ");
        simpleCounting(arr, n);
        System.out.print("2. Dutch National Flag Method - ");
        dutchNationalFlagMethod(arr, n);
    }

    
}
