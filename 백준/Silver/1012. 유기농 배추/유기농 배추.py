import sys
from collections import deque
sys.setrecursionlimit(10 ** 6)

test_case = int(input())
cnt = 0 
dx = [-1,1,0,0]
dy = [0,0,-1,1]
def bfs(x,y):
    q = deque()
    q.append((x,y))
    while q:
        x,y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx < n and 0<=ny < m:
                if graph[nx][ny] == 1 and visited[nx][ny] == False:
                    visited[nx][ny] = True
                    bfs(nx,ny)


for _ in range(test_case):
    n , m, k = map(int,input().split())
    graph = [[0]*(m) for _ in range(n)]
    visited = [[False]*(m) for _ in range(n)]
    cnt = 0 
    for _ in range(k):
        a,b = map(int,input().split())
        graph[a][b] = 1

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1 and visited[i][j] == False:
                visited[i][j] = True
                bfs(i,j)
                cnt+=1
    print(cnt)
    
    
    