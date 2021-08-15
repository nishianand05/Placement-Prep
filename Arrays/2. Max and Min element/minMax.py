# Time complexity - O(n)

    #Worst case = 1+2(n-2) - Sorted in DESC order
    #Best case = 1+(n-2) - Sorted in ASC order


class pair:
    def __init__(self):
        self.min = 0
        self.max = 0

#function annotation    
def simpleLinearSearch(arr: list, n: int) -> pair:
    
    minmax = pair()

    if n == 1:
        minmax.min = arr[0]
        minmax.max = arr[0]
        return minmax

    if arr[0] > arr[1]:
        minmax.min = arr[1]
        minmax.max = arr[0]
    else:
        minmax.min = arr[0]
        minmax.max = arr[1]

    for i in range(2, n):
        if arr[i] > minmax.max:
            minmax.max = arr[i]
        elif arr[i] < minmax.min:
            minmax.min = arr[i]

    return minmax

def binarySearch(arr, low, high):

    maxn = arr[low]
    minn = arr[low]

    if(low == high):
        maxn = arr[low]
        minn = arr[low]
        return (maxn, minn)

    elif (high == low+1):
        if(arr[low] > arr[high]):
            maxn = arr[low]
            minn = arr[high]
        else:
            maxn = arr[high]
            minn = arr[low]

        return (maxn,minn)

    else:

        mid = int((low+high)/2)
        max1, min1 = binarySearch(arr, low, mid)
        max2, min2 = binarySearch(arr, mid+1, high)

    return (max(max1, max2), min(min1, min2))

def compareInPairs(arr, n):

    if(n%2 == 0):
        mx = max(arr[0], arr[1])
        mn = min(arr[0], arr[1])
        i = 2

    else:
        mx = mn = arr[0]
        i = 1

    while(i < (n-1)):
        if(arr[i] < arr[i+1]):
            mx = max(mx, arr[i+1])
            mn = min(mn, arr[i])
        else:
            mx = max(mx, arr[i])
            mn = min(mn, arr[i+1])
        i+=2
    return (mx, mn)

arr = [4,8,3,78,89,35,95]
n = len(arr)

minmax = simpleLinearSearch(arr, n)
print(minmax.max, minmax.min)

minmax = binarySearch(arr, 0, n-1)
print(minmax)

minmax = compareInPairs(arr, n)
print(minmax)


