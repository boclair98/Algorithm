arr = [[0]*101 for _ in range(100)]
a = int(input())
for i in range(a):
    b,c = map(int,input().split())
    for i in range(10):
        for j in range(10):
            arr[i+b][j+c] = 1
res = 0
for i in arr:
    res = res+ sum(i)
print(res)