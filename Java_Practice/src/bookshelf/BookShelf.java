package bookshelf;

// Shelf에 있는 protected 요소들이랑 Queue에 있는 추상 클래스 구현 
public class BookShelf extends Shelf implements Queue {
	@Override
	public void enQueue(String title) {
		shelf.add(title);
	}
	
	@Override
	public String deQueue() {
		return shelf.remove(0);
	}
	
	@Override
	public int getSize() {
		return getCount();
	}
}
