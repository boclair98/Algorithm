import sys 
import heapq
input = sys.stdin.readline
n,e = map(int,input().split())
graph = [[] for _ in range(n+1)]
INF = sys.maxsize
for _ in range(e):
    u,v,w = map(int,input().split())
    graph[u].append((v,w))
    graph[v].append((u,w))
start,end = map(int,input().split())

def dijkstra(start,end):
    distance = [INF] *(n+1)
    pq = [] 
    distance[start] = 0 
    heapq.heappush(pq,(0,start))
    while pq:
        dist,node = heapq.heappop(pq)
        if distance[node] < dist:
            continue 

        for nodes,cost in graph[node]:
            costs = cost + distance[node]
            if costs < distance[nodes]:
                distance[nodes] = costs 
                heapq.heappush(pq,(costs,nodes))
    
    return distance[end]

one = dijkstra(1,start) + dijkstra(start,end) + dijkstra(end,n)
two = dijkstra(1,end) + dijkstra(end,start) + dijkstra(start,n)

value = min(one,two)
if value < INF:
    print(value)
else:
    print(-1)