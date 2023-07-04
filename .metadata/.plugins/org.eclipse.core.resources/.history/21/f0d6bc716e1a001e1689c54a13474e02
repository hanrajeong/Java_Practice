import java.util.Arrays;

/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42576
 *  입력 : 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion
 *  출력 : 완주하지 못한 선수의 이름
 *  기능 : 마라톤 선수들 중 완주하지 못한 선수를 찾는 함
 */

public class July_01_02 {
	public String solution(String[] participant, String[] completion) {
		if((completion == null) || (participant == null)) {
			return "";
		}
		if(completion.length >= participant.length) {
			return "";
		}
		Arrays.sort(participant);
		Arrays.sort(completion);
		int i = 0;
		for(; i < completion.length; i++) {
//			만약 다르면, 해당 선수가 도착 못한 것.
//			예시 : [ana, mislav, mislav, stanko] , [ana, mislav, stanko]
//			completion은 null이 아닌게 보장되는 상황.
			if(!completion[i].equals(participant[i])) {
				break;
			}
		}
		return participant[i];
    }
}
