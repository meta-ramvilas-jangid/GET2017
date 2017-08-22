import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;


public class MyArrayList<T extends Object> {

	private T[] objectList;
	private int listIndex;
	
	public MyArrayList(){
		objectList =(T[])new Object[10];
		listIndex=0;
	}
	
	
	public void add(T obj ){
		if(objectList.length==listIndex){
			increaseListSize();
		}
		objectList[listIndex++]=obj;
	}
	private void increaseListSize(){
		objectList=Arrays.copyOf(objectList, objectList.length+10);
		System.out.println("New Size of ArrayList is : "+objectList.length);
	}
	public void add(T obj, int givenIndex){
		if(givenIndex < 0 && givenIndex >= this.size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		if(objectList.length == listIndex ){
            increaseListSize();
        }
		for(int index = listIndex ; index > givenIndex ; index--  ){
			objectList[index] = objectList[index-1];
		}
		objectList[givenIndex] = obj;
		listIndex++;
	}
	
	public int size(){
        return listIndex;
	}
	
	
	public T get(int index){
        if(index < listIndex){
            return objectList[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
}

	public void remove(int index){
        if(index >=0 && index < listIndex){
            objectList[index] = null;
            int tmp = index;
            while(tmp < listIndex){
            	objectList[tmp] = objectList[tmp+1];
            	
                tmp++;
            }
            objectList[tmp] = null;
            listIndex--;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
         
    }
	
	public void remove(T obj){
		int index = indexOf(obj);
		if(index != -1){
			remove(index);
		}else{
			throw new NoSuchElementException("No such Element exists in list");
		}
	}
	
	public int indexOf(T obj){
		int index;
		for( index = 0; index < listIndex ;index ++){
			if(obj.equals(objectList[index])){
				break;
			}
		}
		if(index == listIndex){
			return -1;
		}
		return index;
	}
	public void clear(){
		int size = this.size();
		for(int index = 0;index < size; index++){
			objectList[index] = null;
			listIndex=0;
		}
	}
	
	public MyArrayList reverse(){
		MyArrayList reverseArrayList = new MyArrayList();
		//reverseArrayList.listIndex = this.listIndex;
		int size = this.size();
		for(int index = 0;index < size; index++){
			reverseArrayList.add(this.get(size-index-1));
		}
		return reverseArrayList;
  	}
	
	public String toString(){
		String str="["+objectList[0];
		for(int i=1;i<listIndex;i++){
			str=str+", "+objectList[i];
		}
		str=str+"]";
		return str;
	}
	
	public void sort1(){
		Arrays.sort(objectList, new Comparator<T>() {
		      public int compare(T o1, T o2) {
		    	  return String.valueOf(o1).compareTo(String.valueOf(o2));
		      }
		        });
	}
	
	
	public MyArrayList add(MyArrayList<T> list){
		for(int index = 0;index < list.size(); index++ ){
			add(list.get(index));
		}
		return this;
	}
	public static void main(String arg[]){
		MyArrayList m=new MyArrayList();
		m.add(1.1);
		m.add(2.1);	m.add(3.1);
		m.add("Ram",1);
		System.out.println(m.get(1));
		m.add("Rohit",1);
		System.out.println(m.get(1));
		System.out.println(""+m.size());
		MyArrayList m1;
		m1=m.reverse();
		System.out.println(m);
		System.out.println(m1);
		m.clear();
		System.out.println("After clear :"+m);
		
		m1.add(1.1);
		m1.add(1.1);
		m1.add(1.1);
		m1.add(1.1);
		m1.add(-2.4);
		m1.add(1);
		m1.add(1.1);
		m1.add(1.1);
		System.out.println(m1);
        m1.sort1();
        System.out.println(m1);
        m.add(12);
        m.add(16);
        m1.add(m);
        System.out.println(m1);
	}
}
