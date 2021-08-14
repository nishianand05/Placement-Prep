# Iterative method

arr = [1,2,8,74,4]

start = 0
end = len(arr)-1

while(start < end):
    temp = arr[start]
    arr[start] = arr[end]
    arr[end] = temp

    start += 1
    end -= 1

print(arr)


# Recursive method

def reverseArray(arr, start, end):
    if(start >= end):
        return arr

    arr[start], arr[end] = arr[end], arr[start]

    return reverseArray(arr, start+1, end-1)

start = 0
end = len(arr)-1
print(reverseArray(arr, start, end))

# Python list slicing

print(arr[::-1])