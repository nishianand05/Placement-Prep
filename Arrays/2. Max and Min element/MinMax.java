public class MinMax {

    static class Pair {
        int min;
        int max;
    };

    // 1. Simple linear search - O(n)
    //      i) Compare first & second element and initialize it as min/max.
    //      ii) Starting from 3rd element, compare each element with min/max and change accordingly.
    //      Worst case (DESC) => 1 + 2(n-2)
    //      Best Case (ASC) => 1 + (n-2)

    static Pair linearSearch(int arr[], int n){

        Pair minmax = new Pair();

        // If only 1 element present, set it as both min and max
        if(n == 1){
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }

        // Compare 1st and 2nd element and set min and max
        if(arr[0] > arr[1]){
            minmax.max = arr[0];
            minmax.min = arr[1];
        } else {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }

        // Compare with min and max from 3rd element and assign accordingly.
        for(int i = 2; i < n; i++){
            if(arr[i] > minmax.max){
                minmax.max = arr[i];
            } else if (arr[i] < minmax.min){
                minmax.min = arr[i];
            }
        }

        return minmax;
    }

    // 2. Binary search - O(n)
    //      i) Divide array into 2 parts & compare min/max of each part to get overall min/max.
    //      
    //      ii) Pair MaxMin(a, n)
    //           if n = 1 set element as both min and max
    //           if n = 2 Compare and set
    //           else
    //               Recursion for min/max of left half
    //               Recursion for min/max for right half
    //               Compare for true min/max and return Pair
    // 
    //      iii) Divide and conquer approach
    //      
    //              T(n) = T(floor(n/2)) + T(ceil(n/2)) + 2
    //              T(2) = 1
    //              T(1) = 0
    // 
    //              n = 2^k
    //              T(n) = 2T(n/2) + 2
    //              T(n) = 3n/2 - 2 if n = pow(2) else more if n != pow(2)


    static Pair binarySearch(int arr[], int low, int high){

        Pair minmax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();

        // len = 1
        if(low == high){
            minmax.min = arr[low];
            minmax.max = arr[low];
            return minmax;
        }

        // len = 2
        if(low+1 == high){
            if(arr[low] > arr[high]){
                minmax.min = arr[high];
                minmax.max = arr[low];
            } else {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }

            return minmax;
        }

        // len > 2
        int mid = (low+high)/2;

        mml = binarySearch(arr, low, mid);
        mmr = binarySearch(arr, mid+1, high);

        if(mml.min < mmr.min){
            minmax.min = mml.min;
        } else {
            minmax.min = mmr.min;
        }

        if(mml.max > mmr.max){
            minmax.max = mml.max;
        } else {
            minmax.max = mmr.max;
        }

        return minmax;
        
    }

    // 3. Compare in pairs - O(n)
    //      i) If n is odd, min/max => 1st element
    //      ii) If n is even, min/max => Compare 1st and 2nd element
    //      iii) For the rest, Pick in pairs and compare
    //      
    //      n is odd => 3(n-1)/2 comparisons
    //      n is even => 3n/2 - 2 comparisons

    static Pair compareInPairs(int arr[], int n){

        Pair minmax = new Pair();
        int i;

        // n is even, compare 1st and 2nd element and set min/max, set i = 2
        if(n%2 == 0){
            if(arr[0] > arr[1]){
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
        } 
        // n is odd, set min/max as 1st element, set i = 1
        else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1; 
        }

        // In while loop, compare in pairs
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

    public static void main(String args[]){
        int arr[] = {4,8,3,78,89,35,95};
        int n = 7;

        Pair minmax = linearSearch(arr, n);

        System.out.printf("1. Simple Linear Search - %d %d\n", minmax.max, minmax.min);

        Pair minmax2 = binarySearch(arr, 0, n-1);

        System.out.printf("2. Binary Search        - %d %d\n", minmax2.max, minmax2.min);

        Pair minmax3 = compareInPairs(arr, n);

        System.out.printf("3. Comapare in Pairs    - %d %d", minmax3.max, minmax3.min);
    }
}