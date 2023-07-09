package bookshelf;

// 책을 넣은 순서대로 꺼내볼 수 있도록 책꽂이를 만들고 싶어서 큐를 구현  
public interface Queue {
	// 책 꽂기  
	void enQueue(String title);
	// 책 빼기  
	String deQueue();
	// 책 개수 반환
	int getSize();
}
