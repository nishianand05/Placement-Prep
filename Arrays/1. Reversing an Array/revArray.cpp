#include<iostream>
using namespace std;
void printArray(int arr[], int n){
    for(int i = 0; i < n; i++){
        cout<<arr[i]<<' ';
    }
}
void iterative(int arr[], int n){
    int start = 0, end = n - 1, temp;
    while(start < end){
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        start++;
        end--;
    }
}
void recursive(int arr[], int start, int end){
    if(start >= end){
        return;
    }

    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

    return recursive(arr, start+1, end-1);
}
int main(){
    int a[5] = {2,4,3,5,6};
    int n = sizeof(a)/sizeof(a[0]);
    cout <<"Before\n";
    printArray(a, n);
    recursive(a, 0, n-1);
    cout <<"\nAfter\n";
    printArray(a, n);
    return 0;
}