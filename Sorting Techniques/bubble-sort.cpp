#include <iostream>
using namespace std;
void bubbleSort(int arr[], int n){
    bool swapped;
    for(int i=0; i<n-1;i++){
        swapped = false;
        for(int j=0; j<n-i-1; j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swapped = true;
            }
        }
        if(swapped == false)
            break;
    }
}
void recursiveBubbleSort(int arr[], int n){
    if(n==1)
        return;
    
    for(int i = 0; i<n-1; i++){
        if(arr[i] > arr[i+1]){
            swap(arr[i], arr[i+1]);
        }
    }

    recursiveBubbleSort(arr, n-1);
}
int main(){
    int arr[] = {4,7,5,7,3,7,0,6};
    int n = 8;
    recursiveBubbleSort(arr,n);
    for(int i = 0; i < n; i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}


// Simplest sorting algorithm
// Swaps adjacent elements if they are in wrong order

// Complexity = O(n^2) even if array is sorted
// Can be optimised with swapped boolean

// Worst case time complexity: O(n^2) Array is reverse sorted
// Best case: O(n) Array is already sorted

