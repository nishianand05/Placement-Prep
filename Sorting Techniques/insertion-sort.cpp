#include<iostream>
using namespace std;
void insertionSort(int arr[], int n){
    int i,j, key;
    for(i = 1; i< n; i++){
        key = arr[i];
        j = i-1;
        
        // If greater than key, move one position ahead
        while(arr[j] > key && j>=0){
            arr[j+1] = arr[j];
            j = j-1;
        }
        arr[j+1] = key;
    }
}
int iterativeBinarySearch(int arr[], int key, int low, int high){
    while(low <= high){
        int mid = low + (high-low)/2;
        if(key == arr[mid])
            return mid+1;
        else if (key > arr[mid])
            low = mid + 1;
        else
            high = mid - 1;
    }

    return low;
}
int recursiveBinarySearch(int arr[], int key, int low, int high){
    if(high <= low){
        return (key > arr[low] ? low+1 : low);
    }

    int mid = (low+high)/2;

    if(key == arr[mid]){
        return mid+1;
    }

    if(key > arr[mid]){
        return recursiveBinarySearch(arr, key, mid+1, high);
    }

    return recursiveBinarySearch(arr, key, low, mid-1);

}
void binaryInsertionSort(int arr[], int n){
    int i, loc, j, k, key;

    for(i=1; i<n;i++){
        j = i-1;
        key = arr[i];
        loc = recursiveBinarySearch(arr, key, 0, j);

        while(j >= loc){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }
}


int main(){
    int arr[] = {4,7,5,7,3,7,90,6};
    int n = 8;
    binaryInsertionSort(arr, n);
    for(int i = 0; i < n; i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}


// Iterate from a[1] to a[n].
// Compare current key to predecessor.
// If current key is smaller than predecessors
        // Compare it to elements before
        // Move greater elements one position up to make space for swapped element.


// Time complexity = o(n^2)
// O(n) comparisions at nth iteration
// can be reduced to O(log n) using binary insertion sort
