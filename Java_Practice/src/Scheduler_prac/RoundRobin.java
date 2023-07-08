package Scheduler_prac;

// Scheduler interface를 inherited
public class RoundRobin implements Scheduler {
    @Override
    public void getNextCall() {
        // Implementation of the sendCallToAgent() method
    	System.out.println("Get the next phone call in a row.");
    }
    
    @Override
    public void sendCallToAgent() {
    	System.out.println("Toss the phone call to the next agent.");
    }
}