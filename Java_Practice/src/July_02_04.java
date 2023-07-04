/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12909
 *  입력 : '(' 또는 ')' 로만 이루어진 문자열 s
 *  출력 : 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 
 */

public class July_02_04 {
	// '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수
	boolean solution(String s) {
		if(s == "") {
			return true;
		}
        boolean answer = true;
        int open = 0;
        char[] str = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
        	if(str[i] == '(') {
        		open += 1;
        	}
        	else {
        		open -= 1;
        	}
        	if(open < 0) {
        		answer = false;
        		break;
        	}
        }
        if(open != 0) {
        	answer = false;
        }

        return answer;
    }
}
