import java.util.LinkedList;
import java.util.List;

public class MyNewQueue<T> {

	List<T>list;
	public MyNewQueue() {
		// TODO Auto-generated constructor stub
		list=new LinkedList<T>();
	}
	
	public void enqueue(T obj){
		list.add(obj);
	}
	
	public T dequeue(){
		if(list.isEmpty()){
			return null;
		}
		T obj= list.get(0);
		list.remove(0);
		return obj;
	}
	public boolean isEmpty(){
		if(list.size()==0){
			return true;
		}
		return false;
	}
	public void display(){
		for(T t:list){
		System.out.print(t +" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyNewQueue<String> m=new MyNewQueue<String>();
		m.enqueue("a");
		m.enqueue("b");m.enqueue("c");m.enqueue("d");m.enqueue("e");m.enqueue("f");
		System.out.println(m.dequeue());
		m.display();

	}

}
