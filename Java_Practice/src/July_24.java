import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
		Queue<Integer> queue = new LinkedList<Integer>();
		int total = 0;
		
		for(int t : truck_weights) {
			
			while(true) {
				if(queue.isEmpty()) {
					queue.offer(t);
					total += t;
					answer++;
					break;
				}
				else if(queue.size() == bridge_length) {
					total -= queue.poll();
				}
				else {
					if(total + t > weight) {
						queue.offer(0);
						answer++;
					}
					else {
						queue.offer(t);
						total += t;
						answer++;
						break;
					}
				}
			}
		}
		return answer + bridge_length;
	}
}