package Scheduler_prac;

public class LeastJob implements Scheduler {
	@Override
    public void getNextCall() {
        // Implementation of the sendCallToAgent() method
    	System.out.println("Get the next phone call in a row.");
    }
    
    @Override
    public void sendCallToAgent() {
    	System.out.println("현재 상담 업무가 없거나 대기가 가장 적은 상담원에게 할당합니다.");
    }
}
