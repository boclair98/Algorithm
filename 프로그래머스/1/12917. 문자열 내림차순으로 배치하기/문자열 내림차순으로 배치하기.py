def solution(s):
    answer = ''
    s = list(s)
    s.sort(reverse = True)
    return "".join(map(str,s))