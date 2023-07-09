/**
 * 인터페이스 관련 코드 연습- 추상 메서드는 인스턴스 생성이 불가능하지만, 인터페이스는 추상 메서드로 구성되어있어도,
 * 인스턴스 생성시 컴파일때 상수로 변환되기 때문에 괜찮음.
 * 디폴트 메소드가 중복되는 경우 각 구현클래스에서 중복되게 선언하는 대신, 공통클래스에서 한번 만 선언해야한다.
 */

package Scheduler_prac;
import java.io.IOException;

public class SchedulerTest_July_08 {
	public static void main(String[] args) throws IOException {
		System.out.println("전화 상담 할당 방식을 선택하세요.");
		System.out.println("R: 한명씩 차례로 할당 ");
		System.out.println("L: 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
		System.out.println("P: 우선순위가 높은 고객 먼저 할당 ");
		// 변수를 입력받
		int ch = System.in.read();
		Scheduler scheduler = null;
		if(ch == 'R' || ch == 'r') {
			scheduler = new RoundRobin();
		}
		else if(ch == 'L' || ch == 'l') {
			scheduler = new LeastJob();
		}
		else if(ch == 'P' || ch == 'p') {
			scheduler = new PriorityAllocation();
		}
		else {
			System.out.println("지원되지 않는 기능입니다.");
			return;
		}
		
		scheduler.getNextCall();
		scheduler.sendCallToAgent();
	}
}
