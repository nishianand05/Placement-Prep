#include<iostream>
using namespace std;
void selectionSort(int arr[], int n){
    int i, j, minIndex;

    for(i = 0; i<n-1; i++){
        minIndex = i;
        for(j = i+1; j < n; j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }

        swap(arr[minIndex], arr[i]);
    }
}
int main(){
    int arr[] = {4,7,5,7,3,7,90,6};
    int n = 8;
    selectionSort(arr, n);
    for(int i = 0; i < n; i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}



// Repeatedly finds minimum element from unsorted part and puts it at the beginning
// Maintains two subarrays
    // Sorted subarray
    // Remaining unsorted subrray

// Time complexity - O(n^2)

// Never takes more than O(n) swaps sp usful when memory is priority


