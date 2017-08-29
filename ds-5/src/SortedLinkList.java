import java.util.LinkedList;
import java.util.List;

public class SortedLinkList<T> {

	List<T> list;

	public SortedLinkList() {
		list = new LinkedList<T>();
	}

	public void insert(T obj) {
		insertAt(0, obj);
	}

	@SuppressWarnings("unchecked")
	public T insertAt(int index, T obj) {
		if (list.size() == 0) {

			list.add(obj);
			return obj;
		} else if (list.size() == index) {
			list.add(index, obj);
			return obj;
		} else if (((Comparable<T>) list.get(index)).compareTo(obj) <= 0
				&& index <= list.size()) {
			return insertAt(++index, obj);
		} else {
			list.add(index, obj);
		}
		return obj;
	}

	public void display() {
		for (T i : list) {
			System.out.println(" " + i + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedLinkList<Integer> l1 = new SortedLinkList<Integer>();
		l1.insert(5);
		l1.insert(3);
		l1.insert(13);
		l1.insert(2);
		l1.insert(-12);
		l1.display();

		SortedLinkList<String> l2 = new SortedLinkList<String>();
		l2.insert("a");
		l2.insert("z");
		l2.insert("A");
		l2.insert("c");
		l2.insert("4");
		l2.display();

	}

}
