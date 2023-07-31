# 프로그래머스 문제 풀이
# https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=python3
# 입력 : operations의 원소는 큐가 수행할 연산
# 출력 : 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return

import heapq

def solution(operations):
    answer = []
    answer2 = []
    heapq.heapify(answer)
    heapq.heapify(answer2)
    
    while len(operations) > 0:
        op = operations.pop(0)
        if op[0] == "I":
            heapq.heappush(answer, int(op[1:]))
            heapq.heappush(answer2, -int(op[1:]))
        elif len(answer) == 0 and len(answer2) == 0:
            continue
        elif op == "D 1":
            temp = heapq.heappop(answer2)
            answer.remove(-temp)
        else:
            temp = heapq.heappop(answer)
            answer2.remove(-temp)
    if len(answer) == 0 and len(answer2) == 0:
        return [0, 0]
    answer = [-heapq.heappop(answer2), heapq.heappop(answer)]
    return answer