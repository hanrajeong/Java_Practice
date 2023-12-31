package Scheduler_prac;

public class PriorityAllocation implements Scheduler {
	@Override
    public void getNextCall() {
        // Implementation of the sendCallToAgent() method
    	System.out.println("고객등급이 가장 높은 고객의 전화를 먼저 가져옵니다.");
    }
    
    @Override
    public void sendCallToAgent() {
    	System.out.println("업무 스킬 값이 가장 높은 상담원에게 우선적으로 배분합니다.");
    }
}
