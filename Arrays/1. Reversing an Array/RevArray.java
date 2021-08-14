import java.io.*;

public class RevArray {

    static void printArr(int a[], int n){
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
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
        printArr(arr, n);
        recursive(arr, 0, n-1);
        printArr(arr, n);
    }
}