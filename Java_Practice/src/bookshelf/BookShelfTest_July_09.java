package bookshelf;

public class BookShelfTest_July_09 {
	public static void main(String[] args) {
		Queue shelfQueue = new BookShelf();
		shelfQueue.enQueue("First Book");
		shelfQueue.enQueue("Second Book");
		shelfQueue.enQueue("Third Book");
		System.out.println(shelfQueue.deQueue());
		System.out.println(shelfQueue.deQueue());
		System.out.println(shelfQueue.deQueue());
	}
}
