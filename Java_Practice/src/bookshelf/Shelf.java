package bookshelf;
import java.util.ArrayList;

public class Shelf {
	// protected로 선언하는 경우 상속받은 클래스에서만 참조할 수 있고, 외부에서는 참조 불가능.
	protected ArrayList<String> shelf;
	// constructor
	public Shelf() {
		shelf = new ArrayList<String>();
	}
	// getter
	public ArrayList<String> getShelf() {
		return shelf;
	}
	public int getCount() {
		return shelf.size();
	}
}
