def solution(n):
    answer = 0
    # 한줄에 하나의 퀸만 들어갈 수 있으므로 1차원 배열로 가능하다. [1, 3, 0, 2]같이.
    stack = []
    for i in range(n):
        stack.append([i])
    while len(stack) > 0:
        arr = stack.pop()
        if len(arr) == n:
            answer += 1
        # y좌표는 겹치는걸 생각하지 않아도 된다. 다음 인덱스가 다음 y좌표를 의미한다.
        for x in range(n):
            # 값이 x좌표를 의미하므로 겹치지 않으면 된다.
            # x좌표도 안겹치고 대각선으로도 만나지 않으면 퀸을 놓을 수 있다.
            if x not in arr:
                for i in range(len(arr)):
                    # |놓을 x좌표 - 놓여있는 x좌표| == |놓을 y좌표 - 놓여있는 y좌표|
                    if abs(arr[i] - x) == abs(i - len(arr)):
                        break
                else:
                    stack.append(arr+[x])
    return answer