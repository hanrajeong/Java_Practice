import java.util.HashMap;

/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42577
 *  입력 : 전화번호부에 적힌 전화번호를 담은 배열 phone_book 
 *  출력 : 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return
 *  Coding 방법 : 주어진 전화번호의 일부 (prefix)가 phone_book 어레이 내 존재하는 번호인지를 확인. 긴 것을 잘라서 존재하는 번호인지 확인하는 것.
 */

public class July_01_04 {
	public boolean solution(String[] phone_book) {
		if(phone_book == null) {
			return true;
		}
        
		boolean answer = true;
		
		HashMap<String, String> phone_map = new HashMap<>();
		
		for(int i = 0; i < phone_book.length; i++) {
			phone_map.put(phone_book[i], phone_book[i]);
		}
		for(int i = 0; i < phone_book.length; i++) {
			for(int j = 0; j <phone_book[i].length(); j++) {
				String prefix = phone_book[i].substring(0, j);
				if(phone_map.containsKey(prefix)) {
					answer = false;
				}
			}
		}
        return answer;
    }
}

/*
 * Comment
 * Map과 HashMap 사이 차이점을 이해하기 어렵다.
 * HashMap을 쓰는게 그냥 iterate하는 것보다 읽어오는 속도가 더 빠르다.
 */