from collections import deque 
import sys
input = sys.stdin.readline
n,s = map(int,input().split())
num = list(map(int,input().split()))
tal = []
num.sort()
count = 0
visited = [False] * n  
def back(k,total):
    global count
    if k >= n :
        return 
    total+=num[k]
    if total == s:
        count+=1
    
    back(k+1,total)
    back(k+1,total-num[k])

back(0,0)
print(count)