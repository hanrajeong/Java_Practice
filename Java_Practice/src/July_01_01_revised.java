/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/120924
 *  입력 : 등차수열 or 등비수열 common
 *  출력 : 마지막 원소 다음으로 올 숫자
 *  기능 : 등차수열 혹은 등비수열의 다음 항 값을 계산하는 함
 */

public class July_01_01_revised {
	// 등차수열인지 등비수열인지 확인해주는 helper 메소드 
	public int checkArray(int[] common) {
		// 기존 main함수에서 null이 아닌 값만 통과시켰기 때문에 null인지 확인 안
		if(common == null) {
			return -1;
		}
		// 인풋 파라미터가 제한 값을 만족했는지 검증 필요
		// 특히, DB의 제약 조건을 만족했는지 여부 체크를 위해 필요함  
		else if(common.length < 2) {
			return -1;
		}
		else if(common.length > 1000) {
			return -1;
		}
		for ( int item : common ) { 
			if ( item <= -1000 || item >= 2000 ) { 
				return -2;
			}
		}
		int first = common[0];
		int second = common[1];
		int third = common[2];
		// 초기 3항을 비교해서 등차가 같다
		if((third - second) == (second - first)) {
			int d = second - first;
			// 나머지 항에 대해서도 등차수열임을 확인
			// 주어진 조건상 등차, 등비수열이 아닌 경우는 없기 때문에 프로그래머스 문제상 불필요한 부분이긴 하지만, extra condition을 검토하기 위
			for(int i = 3; i < common.length; i++) {
				if(d != (common[i] - common[i-1])) {
					return -1;
				}
			}
			return 0;
		}
		else if((third/second) == (second/first)) {
			int r = third/second;
			// 나머지 항에 대해서도 등비수열임을 확인
			// 주어진 조건상 등차, 등비수열이 아닌 경우는 없기 때문에 프로그래머스 문제상 불필요한 부분이긴 하지만, extra condition을 검토하기 위
			for(int i = 3; i < common.length; i++) {
				if(r != (common[i]/common[i-1])) {
					return -1;
				}
			}
			return 1;
		}
		return -1;
	}
	// 메인 메소
	public int solution(int[] common) {
        int answer = 0;
        // check null
        if(common == null) {
        	return answer;
        }
        int checked = this.checkArray(common);
        // -1이면 주어진 common이 등차도 등비도 아닌 경
        if(checked == -1) {
        	return answer;
        }
        // 0이면 주어진 common이 등차수열인 경우 
        else if(checked == 0) {
        	answer = common[common.length-1] + (common[1] - common[0]);
        }
        // 1이면 주어진 common이 등비수열인 경우 
        else {
        	answer = common[common.length-1] * (common[1] / common[0]);
        }
        return answer;
    }
}
