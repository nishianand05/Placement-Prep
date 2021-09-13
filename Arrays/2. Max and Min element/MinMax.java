public class MinMax {
    static class Pair {
        int min;
        int max;
    };

    static Pair linearSearch(int arr[], int n){
        Pair minmax = new Pair();

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
            if(arr[i] > minmax.max){
                minmax.max = arr[i];
            } else if (arr[i] < minmax.min){
                minmax.min = arr[i];
            }
        }

        return minmax;
    }

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

    static Pair compareInPairs(int arr[], int n){

        Pair minmax = new Pair();
        int i;

        if(n%2 == 0){
            if(arr[0]>arr[1]){
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
        } else {
            minmax.min = arr[0];
            minmax.max = arr[0];
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

    public static void main(String args[]){
        int arr[] = {4,8,3,78,89,35,95};
        int n = 7;

        Pair minmax = linearSearch(arr, n);

        System.out.printf("%d %d\n", minmax.max, minmax.min);

        Pair minmax2 = binarySearch(arr, 0, n-1);

        System.out.printf("%d %d\n", minmax2.max, minmax2.min);

        Pair minmax3 = compareInPairs(arr, n);

        System.out.printf("%d %d", minmax3.max, minmax3.min);
    }
}