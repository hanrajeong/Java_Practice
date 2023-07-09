/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42587
 *  입력 : 현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities와, 
 *  	몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location이 매개변수
 *  출력 : 해당 프로세스가 몇 번째로 실행되는지 return
 */

import java.util.*;

public class July_09 {
	public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : priorities) {
        	pQueue.add(num);
        }
        // [2, 1, 3, 2] -> [3, 2, 2, 1]
        while(!pQueue.isEmpty()) {
        	for(int i = 0; i < priorities.length; i++) {
        		// 뽑은 max값의 요소가 
        		if(priorities[i] == pQueue.peek()) {
        			// remove()랑 poll()이랑 다른 건, 
        			// remove() 같은 경우 큐 맨 앞에 있는 값 반환 후 삭제, 비어있으면 NoSuchElementException 에러 발생
        			// poll() 같은 경우 큐 맨 앞에 있는 값 반환 후 삭제, 큐가 비어있을 경우 null 반환
        			pQueue.poll();
        			answer++;
        			if(i == location) {
        				return answer;
        			}
        		}
        	}
        }
        return answer;
        
    }
}
