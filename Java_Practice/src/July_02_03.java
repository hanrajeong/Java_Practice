import java.util.*;
/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42586
 *  입력 : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds
 *  출력 : 각 배포마다 몇 개의 기능이 배포되는지를 return
 */

public class July_02_03 {
	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		// 남은 작업 일수를 담은 배열  
        int[] temp = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
        	// 남은 작업 일수 계산 
        	temp[i] = (int)Math.ceil((float)(100 - progresses[i]) / speeds[i]);
        }
        int prev = temp[0];
        int count = 1;
        //남은 작업 일수를 고려하여 남은 작업 일수가 큰 작업을 기준으로 순서대로 비교하여 배포 가능한 작업의 수를 count에 담
        for(int i = 1; i < progresses.length; i++) {
        	if(prev >= temp[i]) {
        		count += 1;
        	}
        	else {
        		answer.add(count);
        		count = 1;
        		prev = temp[i];
        	}
        }
        answer.add(count);
        return answer.stream().mapToInt(i->i).toArray();
    }
}
