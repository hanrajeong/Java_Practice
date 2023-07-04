import java.util.*;
/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12906
 *  입력 : 각 원소는 숫자 0부터 9까지로 이루어진 배열 arr
 *  출력 : 연속적으로 나타나는 숫자는 하나만 남기고 배열 arr의 원소들의 순서는 유지한채 남은 수들 return
 */

public class July_02_02 {
	// 연속적으로 나타나는 숫자는 제거후 반환하는 main 메소드  
	public int[] solution(int []arr) {
		if(arr == null) {
			int[] answer = {};
			return answer;
		}
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int prev = arr[0];
		answer.add(prev);
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != prev) {
				answer.add(arr[i]);
				prev = arr[i];
			}
		}
		// int[] arr 형태에 맞추어 반환하기 위한 변환 코드  
		return answer.stream().mapToInt(i->i).toArray();
    }
}
