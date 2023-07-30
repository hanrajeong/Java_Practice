import java.util.*;

/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42584?language=java
 *  입력 : 초 단위로 기록된 주식가격이 담긴 배열 prices
 *  출력 : 격이 떨어지지 않은 기간은 몇 초인지를 return
 */

public class July_30 {
	public int[] solution(int[] prices) {
//		제한 사항 체크 : prices의 길이는 2 이상 100,000 이하입니다.
		int l = prices.length;
		int[] answer = new int[l];
        if(prices.length < 1) {
        	return answer;
        }
        else if(prices.length > 100000) {
        	return answer;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < l; i++) {
        	while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
        		answer[stack.peek()] = i - stack.peek();
        		stack.pop();
        	}
        	stack.push(i);
        }
        int temp = 0;
        while(!stack.isEmpty()) {
        	temp = stack.pop();
        	answer[temp] = prices.length - temp - 1;
        }
         return answer;
    }
}
