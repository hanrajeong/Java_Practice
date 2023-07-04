import java.util.HashSet;

/*
 *  프로그래머스 문제 풀이
 *  https://school.programmers.co.kr/learn/courses/30/lessons/1845
 *  입력 : N마리 폰켓몬의 종류 번호가 담긴 배열 nums
 *  출력 : N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return
 *  기능 : 최대한 다양한 종류의 포켓몬을 가질 수 있는 경우의 개수를 찾아
 *  특이사항 : 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분
 */

public class July_01_03 {
	public int solution(int[] nums) {
        int answer = 0;
        int numPocketmon = nums.length / 2;
        HashSet<Integer> setNums = new HashSet<Integer>();
        for(int num : nums) {
        	setNums.add(num);
        }
        int SoloNums = setNums.size();
        if(SoloNums > numPocketmon) {
        	answer = numPocketmon;
        }
        else {
        	answer = SoloNums;
        }
        return answer;
    }
}
