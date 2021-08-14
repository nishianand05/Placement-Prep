def iterative(a, n):
    start = 0
    end = n -1

    while(start < end):
        a[start], a[end] = a[end], a[start]

        start+=1
        end-=1

    print(a)

def recurive(a, start, end):

    if(start >= end):
        print(a)
        return a
    
    a[start], a[end] = a[end], a[start]
    start+=1
    end-=1
    return recurive(a, start, end)


a = [7,7,4,23,6,7]
n = len(a)

iterative(a, n)
recurive(a, 0, n-1)
# slicing
print(a[::-1])