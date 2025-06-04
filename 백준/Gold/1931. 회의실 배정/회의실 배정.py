import sys
input = sys.stdin.readline
n = int(input())
num = []
for _ in range(n):
    a,b= map(int,input().split())
    num.append((a,b))
num.sort(key= lambda x:(x[1],x[0]))
time = []
first = num[0][1]
cnt = 1
for i in range(1,len(num)):
    if num[i][0] >= first:
        first = num[i][1]
        cnt+=1
print(cnt)

    
