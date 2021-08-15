#include <iostream>
using namespace std;

struct Pair {
    int min;
    int max;
};

struct Pair linearSearch(int arr[], int n){

    struct Pair minmax;

    if(n == 1){
        minmax.max = arr[0];
        minmax.min = arr[0];
        return minmax;
    }

    if(arr[0] > arr[1]){
        minmax.max = arr[0];
        minmax.min = arr[1];
    } else {
        minmax.max = arr[1];
        minmax.min = arr[0];
    }

    for(int i = 2; i < n; i++){
        if(arr[i] >  minmax.max){
            minmax.max = arr[i];
        } else if(arr[i] < minmax.min){
            minmax.min = arr[i];
        }
    }

    return minmax;
}

struct Pair binarySearch(int arr[], int low, int high){
    struct Pair minmax, mml, mmr;
    int mid;

    // 1 element
    if(low == high){
        minmax.max = arr[low];
        minmax.min = arr[low];
        return minmax;
    }

    // 2 elements
    if(high == low+1){
        if(arr[low] > arr[high]){
            minmax.max = arr[low];
            minmax.min = arr[high];
        } else {
            minmax.min = arr[low];
            minmax.max = arr[high];
        }
        return minmax;
    }

    mid = (low+high)/2;
    mml = binarySearch(arr, low, mid);
    mmr = binarySearch(arr, mid+1, high);

    if(mml.max > mmr.max){
        minmax.max = mml.max;
    } else {
        minmax.max = mmr.max;
    }

    if(mml.min < mmr.min){
        minmax.min = mml.min;
    } else {
        minmax.min = mmr.min;
    }

    return minmax;
}

struct Pair compareInPairs(int arr[], int n){
    struct Pair minmax;
    int i;
    
    if(n%2 == 0){
        if(arr[0] > arr[1]){
            minmax.max = arr[0];
            minmax.min = arr[1];
        } else {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }
        i = 2;
    } else {
        minmax.max = arr[0];
        minmax.min = arr[0];
        i = 1;
    }

    while(i < n-1){

        if(arr[i] > arr[i+1]){
            if(arr[i] > minmax.max){
                minmax.max = arr[i];
            }
            if(arr[i+1] < minmax.min){
                minmax.min = arr[i+1];
            }
        } else {
            if(arr[i+1] > minmax.max){
                minmax.max = arr[i+1];
            }
            if(arr[i] < minmax.min){
                minmax.min = arr[i];
            }
        }

        i+=2;
    }

    return minmax;
}

int main(){
    int arr[] = {4,8,3,78,89,35,95};
    int n = 7;

    struct Pair minmax = linearSearch(arr, n);
    cout<<minmax.max<<" "<<minmax.min<<"\n";

    struct Pair minmax2 = binarySearch(arr, 0, n-1);
    cout<<minmax2.max<<" "<<minmax2.min<<"\n";

    struct Pair minmax3 = compareInPairs(arr, n);
    cout<<minmax3.max<<" "<<minmax3.min<<"\n";

    return 0;
}