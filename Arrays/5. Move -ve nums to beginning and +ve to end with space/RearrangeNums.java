// https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/

public class RearrangeNums {

    static void printArray(int arr[], int n){
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }


    // 1. Partition process of quicksort 
    //     Time complexity O(n)
    //     Auxiliary space O(1)

    static void partitionProcessOfQuickSort(int arr[], int n){
        int j = 0, temp;
        for(int i=0; i<n; i++){
            if(arr[i] < 0){
                if(i != j){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

   
    // 2. Two Pointer Approach
    // Take two variables while hold 0 and n-1.
    // Loop until left <= right
    //     Check if left and right pointers are negative, then increment left pointers
    //     If left is positive and right is negative, swap, increment and decrement left and right pointers
    //     Else if left and right are positive, decrement right.
        
    static void twoPointerApproach(int arr[], int left, int right){
        while(left <= right){
            if(arr[left] < 0 && arr[right] < 0){
                left++;
            }

            else if (arr[left] > 0 && arr[right] < 0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            else if (arr[left] > 0 && arr[right] > 0){
                right--;
            }

            else {
                left++;
                right--;
            }
        }
    }
    
    public static void main(String args[]) {
        int arr[] = {-3,-5,-9,7,4,-2,5};
        int n = arr.length;

        printArray(arr, n);

        System.out.print("\n1. Partition process of quick sort => ");
        partitionProcessOfQuickSort(arr, n);
        printArray(arr, n);

        System.out.print("\n2. Two pointer approach => ");
        twoPointerApproach(arr, 0, n-1);
        printArray(arr, n);
    }
}
