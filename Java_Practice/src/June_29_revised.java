/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/120956
 *  입력 : 문자열 배열 babbling
 *  출력 : 발음할 수 있는 단어의 개수를 return
 *  기능 : 주어진 문자열 배열인 babbling 중 "aya", "ye", "woo", "ma" 
 *  네 가지 발음을 최대 한 번씩 사용해 조합가능한 단어의 개수를 반환하는 함
 */

public class June_29_revised {
	public int solution(String[] babbling) {
		int answer = 0;
		// babbling이 null인지 확인해야함. 쓰레기값을 받는 경우 제거
		if(babbling == null) {
			return answer;
		}

		for(int i = 0; i < babbling.length; i++) {
			babbling[i]=babbling[i].replace("aya", "0");
			babbling[i]=babbling[i].replace("ye", "0");
			babbling[i]=babbling[i].replace("woo", "0");
			babbling[i]=babbling[i].replace("ma", "0");
			babbling[i]=babbling[i].replace("0", "");
			// NullPointException 방지를 위해 babbling[i].equals("") 대신 하기 코드로 수
			// if문 내에 코드가 1줄이어도 향후 코드 추가를 고려할  {}를 사용해서 코드블럭을 삽입하는 것이 좋음. 
			if("".equals(babbling[i])) {
				answer++;
			}
		}
		return answer;
	}

}
