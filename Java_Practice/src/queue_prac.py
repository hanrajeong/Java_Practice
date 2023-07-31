# 프로그래머스 문제 풀이
# https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=python3
# 입력 : operations의 원소는 큐가 수행할 연산
# 출력 : 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return

def solution(operations):
    answer = []
    queue = []
    for op in operations:
        if op[0] == "I":
            queue.append(int(op[2:]))
        elif len(queue) == 0:
            continue
        elif op == "D 1":
            maxNum = max(queue)
            queue.remove(maxNum)
        else:
            minNum = min(queue)
            queue.remove(minNum)
    if len(queue) == 0:
        answer = [0,0]
    else:
        answer = [max(queue), min(queue)]
    return answer