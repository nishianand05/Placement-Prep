// https://www.geeksforgeeks.org/quick-sort/

#include <iostream>
using namespace std;

// Swap Function
void swap(int *a, int *b){
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int arr[], int low, int high){

    
    int pivot = arr[high]; // Last element is pivot
    int i = (low - 1); // Index of smaller element

    for(int j = low; j <= (high - 1); j++){
        // Check if current element is smaller than pivot
        if(arr[j] < pivot){
            i++; // Increment index of smaller element
            swap(&arr[i], &arr[j]);
        }
    }

    // Place pivot in correct position
    swap(&arr[i + 1], &arr[high]);
    return (i+1);
}

void quickSort(int arr[], int low, int high){
    if(low < high){
        int partitionIndex = partition(arr, low, high);
        quickSort(arr, low, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, high);
    }
}

void printArray(int arr[], int size){
    int i;
    for(i = 0; i < size; i++){
        cout << arr[i] << " ";
    }

    cout << endl;
}

int main(){
    int arr[] = {3,6,8,4,2,4,0};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout << "Array: ";
    printArray(arr, n);
    quickSort(arr, 0, n-1);
    cout << "Quick sorted array: ";
    printArray(arr, n);
    return 0;
}


// Quick Sort
//      => Divide and Conquer Algo
//      => Picks a pivot and partitions array around pivot
//      => Put all x < pivot elements before pivot and x > pivot after pivot.
//      => T(n) = T(k) + T(n - k - 1) + θ(n)
//      => First two terms - 2 recursive calls, Last term - Partition process
//      => k - no. of elements smaller than pivot
//      => Worst Case - Partition process always picks greatest or smallest. Partition strategy with last element as pivot, worst case would occur when array is already sorted. 
//               T(n) = T(0) + T(n-1) + θ(n)
//               which is equivalent to, 
//               T(n) = T(n-1) + θ(n), Recurrence is θ(n^2)
//      => Best Case - Middle element is always picked as pivot. 
//               T(n) = 2T(n/2) + θ(n), Recurrence θ(nlogn)
//      => Avergae case - T(n) = T(n/9) + T(9n/10) + θ(n), Recurrence is θ(nlogn)