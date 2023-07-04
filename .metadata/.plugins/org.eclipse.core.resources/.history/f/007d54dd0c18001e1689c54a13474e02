/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42577
 *  입력 : 전화번호부에 적힌 전화번호를 담은 배열 phone_book 
 *  출력 : 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return
 *  기능 : 최대한 다양한 종류의 포켓몬을 가질 수 있는 경우의 개수를 찾아
 *  특이사항 : 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분
 */

public class July_01_04 {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        // check null
        if(phone_book == null) {
        	return answer;
        }
        for(int i = 0; i < phone_book.length; i++) {
        	for(int j = i+1; j < phone_book.length; j++) {
        		/*
        		 * 새로운 내장 함수 from official document
        		 * 
        		 * public String substring(int startIndex)  // type - 1  
        		 * public String substring(int startIndex, int endIndex)  // type - 2  
        		 * startIndex : starting index is inclusive
        		 * endIndex : ending index is exclusive
        		 */
        		if(!phone_book[i].substring(0, 1).equals(phone_book[j].substring(0, 1))) {
        			continue;
        		}
        		if(phone_book[i].length() < phone_book[j].length()) {
        			if(phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])) {
        				return false;
        			}
        		}
        		else {
        			if(phone_book[i].substring(0, phone_book[j].length()).equals(phone_book[j])) {
        				return false;
        			}
        		}
        		
        	}
        }
        return answer;
    }
}
