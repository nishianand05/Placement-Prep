import java.io.*;

public class RevArray {

    static void printArr(int a[], int n){
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
   
    // 1. Iterative method - O(n)
    //      i) Initialize start = 0, end = n-1
    //      ii) In loop, 
    //              Swap a[start] & a[end]
    //              Change start = start + 1, end = end -1

    static void iterative(int a[], int start, int end){
        int temp;

        while(start < end){
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }

    // 2. Recursive method - O(n)
    //      i) Initialize start = 0, end = n-1
    //      ii) Swap a[start] & a[end]
    //      iii) Call recursively for rest of the array with start+1, end-1

    static void recursive(int a[], int start, int end){
        int temp;
        if(start >= end){
            return;
        }

        temp = a[start];
        a[start] = a[end];
        a[end] = temp;

        recursive(a, start+1, end-1);
    }
 
    public static void main(String args[]){

        int arr[] = {1,2,5,3,6,8};
        int n = 6;
        System.out.print("Before - ");
        printArr(arr, n);
        //iterative(arr, 0, n-1);
        recursive(arr, 0, n-1);
        System.out.print("After  - ");
        printArr(arr, n);
    }
}