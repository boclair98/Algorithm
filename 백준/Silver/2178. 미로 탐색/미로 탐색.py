from collections import deque
import sys
# input = sys.stdin.readline
n,m = map(int,input().split())

number = [list(map(int,input())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]
dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    while q:
        x1,y1 = q.popleft()
        for i in range(4):
            nx = x1 + dx[i]
            ny = y1 + dy[i]
            if 0<=nx<n and 0<=ny<m:
                if(visited[nx][ny] == False and number[nx][ny] == 1):
                    visited[nx][ny] = True
                    number[nx][ny] = number[x1][y1] + 1 
                    q.append((nx,ny))
    
    return number[n-1][m-1]

    


print(bfs(0,0))




