def solution(s):
    answer = ""
    idx = len(s)
    if(idx % 2 == 1):
        answer = s[idx//2]
    else:
        answer = s[idx//2-1:idx//2+1]  
    print(answer)
    return answer
    