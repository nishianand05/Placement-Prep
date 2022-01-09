#include<iostream>
using namespace std;
void merge(int arr[], int left, int mid, int right){
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int arr1[100], arr2[100];

    for(int i=0; i<n1; i++){
        arr1[i] = arr[left + i];
    }
    for(int j = 0; j<n2; j++){
        arr2[j] = arr[mid + 1 + j];
    }

    int i = 0, j = 0, k = left;

    while(i < n1 && j < n2){
        if(arr1[i] <= arr2[j]){
            arr[k] = arr1[i];
            i++;
        } else {
            arr[k] = arr2[j];
            j++;
        }
        k++;
    }

    while(i < n1){
        arr[k] = arr1[i];
        i++;
        k++;
    }

    while(j < n2){
        arr[k] = arr2[j];
        j++;
        k++;
    }
}

void mergeSort(int arr[], int l, int r){
    if(l < r){
        int m = l+ (r-l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }
}

void printArray(int arr[], int n){
    for(int i = 0; i < n; i++){
        cout << arr[i] << " " << endl;
    }
}

int main(){
    int n = 5;
    int arr[5] = {5,8,3,0,4};
    mergeSort(arr, 0, n-1);
    printArray(arr, n);
    return 0;
}
